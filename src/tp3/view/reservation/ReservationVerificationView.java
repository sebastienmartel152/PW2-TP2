package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import tp3.controller.ReservationController;
import tp3.view.DTO.DTOSelectedDate;
import tp3.view.DTO.Month;

@SuppressWarnings("serial")
public class ReservationVerificationView extends ReservationView implements ActionListener {
	
	private static final String MONTH_UPDATED = "MONTH_UPDATE";
	private static final String CHECK_AVAILABILITY_ACTION = "CHECK_AVAILABILITY";
	
	// Montant total avant les taxes
	private static final String TOTAL_AMOUNT_LABEL_TEXT = "Montant total avant taxes: ";

	// Sélection de la date
	private static final String AVAILABLE_COTTAGE_DIALOG = "Le chalet est disponible! Veuillez entrer les informations nécessaires à la facturation";
	private static final String UNAVAILABLE_COTTAGE_DIALOG = "Désolé, le chalet sélectionné n'est pas disponible pour cette date.";
	private static final String CHECK_DISPONIBILITY_LABEL = "Vérifier la disponibilité...";
	private static final int CURRENT_YEAR = 2016;
	private static final int MAX_YEAR = 2020;
	JButton checkAvailabilityButton;
	
	private JComboBox<Integer> dayCombo;
	private JComboBox<Month> monthCombo;
	private JComboBox<Integer> yearCombo;
	
	// Formulaire d'information nécessaire à la facturation
	JPanel formPanel;
	
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;
	
	private static final String NAME_LABEL = "Nom et prénom: ";
	private static final String ADDRESS_LABEL = "Addresse: ";
	private static final String PHONE_LABEL = "Téléphone: ";
	private static final String EMAIL_LABEL = "Courriel: ";

	
	
	private ReservationController reservationController;
	private double totalCost;
	

	
	
	public ReservationVerificationView(ReservationController reservationController, double totalCost){
		super();
		this.reservationController = reservationController;
		this.totalCost = totalCost;
		setUpComboBoxes();
		setupPanel();
		setupContactInfoForm();
	}
		
	private void setUpComboBoxes() {
		dayCombo = new JComboBox<Integer>();
		
		for(int i=1; i<=31; i++){
			dayCombo.addItem(i);
		}
		
		monthCombo = new JComboBox<Month>(Month.values());
		monthCombo.addActionListener(this);
		monthCombo.setActionCommand(MONTH_UPDATED);
		
		yearCombo = new JComboBox<Integer>();
		for(int i=CURRENT_YEAR;i<=MAX_YEAR;i++){
			yearCombo.addItem(i);
		}
		
	}

	private void setupPanel() {
		JPanel topPanel = new JPanel(new BorderLayout());
		
		JPanel priceAndDatePanel = new JPanel(new GridLayout(0, 2));
		JLabel totalCostTextLabel = new JLabel(TOTAL_AMOUNT_LABEL_TEXT);
		JLabel totalCostLabel = new JLabel(formatPrice(this.totalCost));
		
		priceAndDatePanel.add(totalCostTextLabel);
		priceAndDatePanel.add(totalCostLabel);
		
		JLabel chooseDateLabel = new JLabel("Date d'arrivée : ");

		priceAndDatePanel.add(chooseDateLabel);
		
		JPanel dateSelectionPanel = new JPanel();
		dateSelectionPanel.add(dayCombo);
		dateSelectionPanel.add(monthCombo);
		dateSelectionPanel.add(yearCombo);
		priceAndDatePanel.add(dateSelectionPanel);
		
		
		checkAvailabilityButton = new JButton(CHECK_DISPONIBILITY_LABEL);
		checkAvailabilityButton.addActionListener(this);
		checkAvailabilityButton.setActionCommand(CHECK_AVAILABILITY_ACTION);
		
		topPanel.add(priceAndDatePanel, BorderLayout.NORTH);
		topPanel.add(checkAvailabilityButton, BorderLayout.CENTER);
		
		this.add(topPanel);
	}
	
	
	private static String formatPrice(double priceDouble){
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(priceDouble) + "$";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case MONTH_UPDATED:
			updateDaysCombo();
			break;
		case CHECK_AVAILABILITY_ACTION:
			checkAvailability();
		}
		
		
	}

	private void checkAvailability() {
		int selectedDay = (int) this.dayCombo.getSelectedItem();
		Month selectedMonth = (Month) this.monthCombo.getSelectedItem();
		int selectedYear = (int) this.yearCombo.getSelectedItem();
		
		DTOSelectedDate selectedDateDTO = new DTOSelectedDate(selectedDay, selectedMonth.getNumericValue(), selectedYear);
		
		boolean isAvailable = this.reservationController.checkAvailability(selectedDateDTO);
		
		if(isAvailable){
			JOptionPane.showMessageDialog(this, AVAILABLE_COTTAGE_DIALOG);
			displayContactInfoForm();
		}else{
			JOptionPane.showMessageDialog(this, UNAVAILABLE_COTTAGE_DIALOG);
		}
	}

	private void setupContactInfoForm() {
		formPanel = new JPanel(new GridLayout(0,2));

		JLabel nameLabel = new JLabel(NAME_LABEL);
		JLabel addressLabel = new JLabel(ADDRESS_LABEL); 
		JLabel phoneLabel = new JLabel(PHONE_LABEL);
		JLabel emailLabel = new JLabel(EMAIL_LABEL);
		
		nameTextField = new JTextField();
		addressTextField = new JTextField();
		phoneTextField = new JTextField();
		emailTextField = new JTextField();
		
		
		formPanel.add(nameLabel);
		formPanel.add(nameTextField);
		formPanel.add(addressLabel);
		formPanel.add(addressTextField);
		formPanel.add(phoneLabel);
		formPanel.add(phoneTextField);
		formPanel.add(emailLabel);
		formPanel.add(emailTextField);
		
		this.add(formPanel);
		formPanel.setVisible(false);
	}
	
	private void displayContactInfoForm(){
		this.checkAvailabilityButton.setEnabled(false);
		this.monthCombo.setEnabled(false);
		this.dayCombo.setEnabled(false);
		this.yearCombo.setEnabled(false);
		
		this.formPanel.setVisible(true);
		this.reservationController.setFinalButton();
	}

	private void updateDaysCombo() {
		Month selectedMonth = (Month) this.monthCombo.getSelectedItem();
		int maxNbDays = selectedMonth.getMaxNbDays();
		
		dayCombo.removeAllItems();
		
		for(int i=1; i<=maxNbDays; i++){
			dayCombo.addItem(i);
		}
		
		if(selectedMonth.getNumericValue() == 2){
			int selectedYear = yearCombo.getSelectedIndex();
			if(selectedYear % 4 == 0){
				dayCombo.addItem(29);
			}
		}
	}
	
	
	@Override
	public void sendInformation() {
		// TODO Auto-generated method stub
		
	}
}

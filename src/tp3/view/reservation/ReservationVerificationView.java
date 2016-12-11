package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp3.controller.ReservationController;
import tp3.view.DTO.DTOSelectedDate;
import tp3.view.DTO.Month;

@SuppressWarnings("serial")
public class ReservationVerificationView extends ReservationView implements ActionListener {
	
	private static final String CHECK_DISPONIBILITY_LABEL = "Vérifier la disponibilité...";
	private static final int CURRENT_YEAR = 2016;
	private static final int MAX_YEAR = 2020;

	private static final String TOTAL_AMOUNT_LABEL_TEXT = "Montant total avant taxes: ";
	private static final String MONTH_UPDATED = "MONTH_UPDATE";
	private static final String CHECK_AVAILABILITY_ACTION = "CHECK_AVAILABILITY";
	
	private ReservationController reservationController;
	private double totalCost;
	
	private JComboBox<Integer> dayCombo;
	private JComboBox<Month> monthCombo;
	private JComboBox<Integer> yearCombo;
	
	
	public ReservationVerificationView(ReservationController reservationController, double totalCost){
		super();
		this.reservationController = reservationController;
		this.totalCost = totalCost;
		setUpComboBoxes();
		setupPanel();
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
		
		
		JButton checkAvailabilityButton = new JButton(CHECK_DISPONIBILITY_LABEL);
		checkAvailabilityButton.setActionCommand(CHECK_AVAILABILITY_ACTION);
		
		topPanel.add(priceAndDatePanel, BorderLayout.NORTH);
		topPanel.add(checkAvailabilityButton, BorderLayout.CENTER);
		
		this.add(topPanel);
	}
	
	
	@Override
	public void sendInformation() {
		// TODO Auto-generated method stub
		
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
		
		this.reservationController.checkAvailability(selectedDateDTO);
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
}

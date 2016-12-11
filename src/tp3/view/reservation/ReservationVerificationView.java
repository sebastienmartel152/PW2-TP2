package tp3.view.reservation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp3.controller.ReservationController;
import tp3.view.DTO.Month;

@SuppressWarnings("serial")
public class ReservationVerificationView extends ReservationView implements ActionListener {
	
	private static final int CURRENT_YEAR = 2016;
	private static final int MAX_YEAR = 2020;

	private static final String TOTAL_AMOUNT_LABEL_TEXT = "Montant total avant taxes: ";
	private static final String MONTH_UPDATED = "MONTH_UPDATE";
	
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
		JPanel panel = new JPanel(new GridLayout(0, 2));
		JLabel totalCostTextLabel = new JLabel(TOTAL_AMOUNT_LABEL_TEXT);
		JLabel totalCostLabel = new JLabel(formatPrice(this.totalCost));
		
		panel.add(totalCostTextLabel);
		panel.add(totalCostLabel);
		
		JLabel chooseDateLabel = new JLabel("Date d'arrivée : ");

		
		panel.add(chooseDateLabel);
		
		JPanel dateSelectionPanel = new JPanel();
		dateSelectionPanel.add(dayCombo);
		dateSelectionPanel.add(monthCombo);
		dateSelectionPanel.add(yearCombo);
		
		panel.add(dateSelectionPanel);
		
		this.add(panel);
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
		}
		
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

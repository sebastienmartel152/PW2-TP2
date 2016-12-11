package tp3.view.reservation;

import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tp3.controller.ReservationController;

@SuppressWarnings("serial")
public class ReservationVerificationView extends ReservationView {
	

	private static final String TOTAL_AMOUNT_LABEL_TEXT = "Montant total avant taxes: ";
	
	private ReservationController reservationController;
	private double totalCost;
	
	public ReservationVerificationView(ReservationController reservationController, double totalCost){
		super();
		this.reservationController = reservationController;
		this.totalCost = totalCost;
		
		setupPanel();
	}
		
	private void setupPanel() {
		JPanel panel = new JPanel();
		JLabel totalCostTextLabel = new JLabel(TOTAL_AMOUNT_LABEL_TEXT);
		JLabel totalCostLabel = new JLabel(formatPrice(this.totalCost));
		
		panel.add(totalCostTextLabel);
		panel.add(totalCostLabel);
		
		
		
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
}

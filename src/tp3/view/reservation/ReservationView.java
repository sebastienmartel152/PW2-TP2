package tp3.view.reservation;

import javax.swing.JPanel;

import tp3.view.DTO.DTOBaseInfo;

@SuppressWarnings("serial")
public abstract class ReservationView extends JPanel {
	
	public abstract boolean validateInputs();

}

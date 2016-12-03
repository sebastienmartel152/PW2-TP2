package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tp3.controller.ReservationController;

@SuppressWarnings("serial")
public class ReservationMainView extends JFrame implements ActionListener {
	
	private static final String BUTTON_NEXT_LABEL = "Suivant";

	private static final String VIEW_TITLE = "Réservation d'un chalet";
	
	private static final String ACTION_NEXT = "NEXT";

	private static final Point DEFAULT_LOCATION = new Point(200, 30);
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private ReservationController reservationController;
	
	private JPanel centralPanel;
	
	public ReservationMainView(ReservationController reservationController){
		super();
		this.initialize();
		this.setUpComponents();
		
		this.reservationController = reservationController;
	}
	
	private void initialize() {
		this.setTitle(ReservationMainView.VIEW_TITLE);
		this.setLocation(ReservationMainView.DEFAULT_LOCATION);
		this.setSize(ReservationMainView.DEFAULT_SIZE);
		
	}

	private void setUpComponents() {
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
		JButton nextButton = new JButton(BUTTON_NEXT_LABEL);
		nextButton.addActionListener(this);
		nextButton.setActionCommand(ACTION_NEXT);
		
		buttonPanel.add(nextButton, BorderLayout.EAST);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ACTION_NEXT:
			this.reservationController.displayNextPanel();
			break;
		}
		
	}
	
	
	
}

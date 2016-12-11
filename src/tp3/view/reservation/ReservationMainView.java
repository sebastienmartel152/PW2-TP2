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
	
	private ReservationView centralPanel;
	private ReservationController reservationController;
	
	private JButton nextButton;
	
	public ReservationMainView(ReservationController reservationController, ReservationView firstPanel){
		super();
		this.centralPanel = firstPanel;
		this.reservationController = reservationController;
		
		this.initialize();
		this.setUpComponents();
	}
	
	private void initialize() {
		this.setTitle(ReservationMainView.VIEW_TITLE);
		this.setLocation(ReservationMainView.DEFAULT_LOCATION);
		this.setSize(ReservationMainView.DEFAULT_SIZE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void setUpComponents() {
		this.add(this.centralPanel);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
		nextButton = new JButton(BUTTON_NEXT_LABEL);
		nextButton.addActionListener(this);
		nextButton.setActionCommand(ACTION_NEXT);
		
		buttonPanel.add(nextButton, BorderLayout.EAST);
	}
	
	public void setPanel(ReservationView newPanel){
		this.centralPanel.setVisible(false);
		
		this.add(newPanel);
		
		this.centralPanel = newPanel;
		this.centralPanel.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ACTION_NEXT:
			this.reservationController.nextPanel();
			break;
		}
	}

	public void disableNextButton() {
		this.nextButton.setEnabled(false);
	}
	
	
	
}

package tp3.view.admin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JTextField;

import tp3.controller.AdminController;
import tp3.controller.ReservationController;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.TransportType;
import tp3.view.reservation.ReservationMainView;

public class AdminView extends JFrame {
	
	private static final String ADMIN_LABEL_TEXT = "Écran des réservations";
	private static final String VIEW_TITLE = "Administration";
	private static final Point DEFAULT_LOCATION = new Point(200,30);
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private AdminController adminController;
	
	public AdminView(AdminController adminController){
		super();
		this.adminController = adminController;
		this.initialize();
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUpAdminPanel();
	}

	

	private void setUpAdminPanel() {
			JPanel adminPanel = new JPanel();
			this.add(adminPanel, BorderLayout.CENTER);
			
			JPanel messagePanel = new JPanel();
			this.add(messagePanel,  BorderLayout.NORTH);
			JLabel adminLabel = new JLabel(AdminView.ADMIN_LABEL_TEXT);
			messagePanel.add(adminLabel,  BorderLayout.CENTER);
			
			JTable reservationTable = new JTable();
	}

	private void initialize() {
		this.setTitle(AdminView.VIEW_TITLE);
		this.setLocation(AdminView.DEFAULT_LOCATION);
		this.setSize(AdminView.DEFAULT_SIZE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}
	

}
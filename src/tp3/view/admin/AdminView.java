package tp3.view.admin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import tp3.controller.AdminController;
import tp3.model.reservation.receipt.ReceiptBuilder;


@SuppressWarnings("serial")
public class AdminView extends JFrame {
	
	private static final int NUMBER_OF_COLUMNS = 7;
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

	private void initialize() {
		this.setTitle(AdminView.VIEW_TITLE);
		this.setLocation(AdminView.DEFAULT_LOCATION);
		this.setSize(AdminView.DEFAULT_SIZE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}
	
	private void setUpComponents() {
		this.setUpAdminPanel();
	}

	private void setUpAdminPanel() {
			JPanel adminPanel = new JPanel(new BorderLayout());
			this.add(adminPanel, BorderLayout.NORTH);
			
			JLabel adminLabel = new JLabel(AdminView.ADMIN_LABEL_TEXT);
			adminPanel.add(adminLabel, BorderLayout.NORTH);
			
			JPanel centerPanel = new JPanel(new BorderLayout());
			this.add(centerPanel, BorderLayout.CENTER);
			
			
			DefaultTableModel tableModel = this.createTableModel();
			JTable reservationTable = new JTable(tableModel);
			centerPanel.add(reservationTable, BorderLayout.CENTER);
	}

	private DefaultTableModel createTableModel() {
		Object[][] itemData = this.convert2Data();
		String[] columnNames = {"Nom", "Adresse", "Téléphone", "Courriel", "Début du séjour", "Nombre de jours", "Total"};
		
		return new DefaultTableModel(itemData, columnNames);
	}

	private Object[][] convert2Data() {
		Object[][] data = new Object[this.adminController.getRepository().count()][NUMBER_OF_COLUMNS];
		ArrayList<ReceiptBuilder> receiptList = new ArrayList<ReceiptBuilder>(this.adminController.getRepository().listAll());		
				int i=0;
		for(ReceiptBuilder item : receiptList){
			data[i][0] = item.getName();
			data[i][1] = item.getAddress();
			data[i][2] = item.getPhone();
			data[i][3] = item.getMail();
			data[i][4] = item.getDate();
			data[i][5] = item.getNumberOfDays();
			data[i][6] = item.getTotal();
			i++;
		}
		
		
		
		
		return data;
	}

	
	

}
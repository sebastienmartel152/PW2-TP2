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
	
	private static final String TOTAL_PRICE_LABEL = "Total";
	private static final String NB_DAYS_LABEL = "Nombre de jours";
	private static final String DATESTART_LABEL = "Début du séjour";
	private static final String COTTAGE_LABEL = "Chalet";
	private static final String MAIL_LABEL = "Courriel";
	private static final String PHONE_LABEL = "Téléphone";
	private static final String ADDRESS_LABEL = "Adresse";
	private static final String NAME_LABEL = "Nom";
	private static final int NUMBER_OF_COLUMNS = 8;
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
		String[] columnNames = {NAME_LABEL, ADDRESS_LABEL, PHONE_LABEL, MAIL_LABEL, COTTAGE_LABEL, DATESTART_LABEL, NB_DAYS_LABEL, TOTAL_PRICE_LABEL};
		
		return new DefaultTableModel(itemData, columnNames);
	}

	private Object[][] convert2Data() {
		Object[][] data = new Object[this.adminController.getRepository().count() + 1][NUMBER_OF_COLUMNS];
		ArrayList<ReceiptBuilder> receiptList = new ArrayList<ReceiptBuilder>(this.adminController.getRepository().listAll());		
				int i=0;
				
				data[i][0] = NAME_LABEL;
				data[i][1] = ADDRESS_LABEL;
				data[i][2] = PHONE_LABEL;
				data[i][3] = MAIL_LABEL;
				data[i][4] = COTTAGE_LABEL;
				data[i][5] = DATESTART_LABEL;
				data[i][6] = NB_DAYS_LABEL;
				data[i][7] = TOTAL_PRICE_LABEL;
				i++;
		for(ReceiptBuilder item : receiptList){
			
			data[i][0] = item.getName();
			data[i][1] = item.getAddress();
			data[i][2] = item.getPhone();
			data[i][3] = item.getMail();
			data[i][4] = item.getCottageType();
			data[i][5] = item.getDate();
			data[i][6] = item.getNumberOfDays();
			data[i][7] = item.getTotal();
			i++;
		}
		
		
		
		
		return data;
	}

	
	

}
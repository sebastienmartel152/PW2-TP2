package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tp3.view.DTO.DTOReceiptActivityItem;
import tp3.view.DTO.DTOReceiptContactInfo;

@SuppressWarnings("serial")
public class ReservationReceiptView extends ReservationView {
	
	private static final int NUMBER_OF_COLUMNS = 2;
	ArrayList<DTOReceiptActivityItem> receiptItems;
	ArrayList<DTOReceiptContactInfo> customerItems;
	
	public ReservationReceiptView(ArrayList<DTOReceiptActivityItem> receiptItems, ArrayList<DTOReceiptContactInfo> customerItems){
		super();
		this.customerItems = customerItems;
		this.receiptItems = receiptItems;
		this.setupPanel();
	}
	
	private void setupPanel(){
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Merci d'avoir réservé le chalet! Voici votre facture détaillée:");
		panel.add(label, BorderLayout.NORTH);
		
		DefaultTableModel activityTableModel = this.createActivityTableModel();
		JTable activityTable = new JTable(activityTableModel);
		
		DefaultTableModel contactTableModel = this.createContactTableModel();
		JTable contactTable = new JTable(contactTableModel);
		
		JScrollPane activityScrollPane = new JScrollPane(activityTable);
		activityScrollPane.setPreferredSize(new Dimension(380, 280));
		
		JScrollPane contactScrollPane = new JScrollPane(activityTable);
		contactScrollPane.setPreferredSize(new Dimension(380, 280));
		
		
		panel.add(activityScrollPane, BorderLayout.CENTER);
		panel.add(contactScrollPane, BorderLayout.NORTH);

		
		this.add(panel);
	}

	

	private DefaultTableModel createContactTableModel() {
		Object[][] itemData = this.convertContact2Data();
		String[] columnNames = {"Item", "Info"};
		
		return new DefaultTableModel(itemData, columnNames);
	}

	private Object[][] convertContact2Data() {
		Object[][] data = new Object[this.customerItems.size()][NUMBER_OF_COLUMNS];
		
		int i=0;
		for(DTOReceiptContactInfo item : this.customerItems){
			data[i][0] = item.description;
			data[i][1] = item.value;
			i++;
		}
		
		return data;
	}

	private DefaultTableModel createActivityTableModel(){
		Object[][] itemData = this.convertActivity2Data();
		String[] columnNames = {"Item", "Prix"};
		
		return new DefaultTableModel(itemData, columnNames);
	}
	
	private Object[][] convertActivity2Data(){
		Object[][] data = new Object[this.receiptItems.size()][NUMBER_OF_COLUMNS];
		
		int i=0;
		for(DTOReceiptActivityItem item : this.receiptItems){
			data[i][0] = item.description;
			data[i][1] = formatPrice(item.price);
			i++;
		}
		
		return data;
	}
	
	@Override
	public void sendInformation() {
		// pas d'information à renvoyer au controlleur
	}
	
	private static String formatPrice(double priceDouble){
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(priceDouble) + "$";
	}
	
}

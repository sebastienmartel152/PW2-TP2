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

import tp3.view.DTO.DTOReceiptItem;

@SuppressWarnings("serial")
public class ReservationReceiptView extends ReservationView {
	
	private static final int NUMBER_OF_COLUMNS = 2;
	ArrayList<DTOReceiptItem> receiptItems;
	
	public ReservationReceiptView(ArrayList<DTOReceiptItem> receiptItems){
		super();
		
		this.receiptItems = receiptItems;
		this.setupPanel();
	}
	
	private void setupPanel(){
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Merci d'avoir réservé le chalet! Voici votre facture détaillée:");
		panel.add(label, BorderLayout.NORTH);
		
		DefaultTableModel tableModel = this.createTableModel();
		JTable table = new JTable(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(380, 280));
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		this.add(panel);
	}

	

	private DefaultTableModel createTableModel(){
		Object[][] itemData = this.convert2Data();
		String[] columnNames = {"Item", "Prix"};
		
		return new DefaultTableModel(itemData, columnNames);
	}
	
	private Object[][] convert2Data(){
		Object[][] data = new Object[this.receiptItems.size()][NUMBER_OF_COLUMNS];
		
		int i=0;
		for(DTOReceiptItem item : this.receiptItems){
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

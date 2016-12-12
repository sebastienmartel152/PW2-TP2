package tp3.controller;

import tp3.model.reservation.repository.ReceiptRepository;
import tp3.view.admin.AdminView;

public class AdminController {
	
	private ReceiptRepository repository;
	
	private AdminView adminView;
	
	public AdminController(ReceiptRepository repository){
		this.repository = repository;
		this.adminView = new AdminView(this);
	}
	
	public void displayWindow(){
		this.adminView.setVisible(true);
	}
	
	

}
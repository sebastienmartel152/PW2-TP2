package tp3;

import tp3.controller.WelcomeController;
import tp3.model.reservation.repository.ReceiptMemoryRepository;
import tp3.model.reservation.repository.ReceiptRepository;

public class MainAppTP3 {

	public static void main(String[] args) {
		ReceiptRepository repository = new ReceiptMemoryRepository();
		WelcomeController welcomeController = new WelcomeController(repository);
		
		
		welcomeController.startApplication();
	}

}

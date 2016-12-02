package tp3;

import tp3.controller.WelcomeController;
import tp3.model.reservation.repository.ReservationMemoryRepository;
import tp3.model.reservation.repository.ReservationRepository;

public class MainAppTP3 {

	public static void main(String[] args) {
		ReservationRepository repository = new ReservationMemoryRepository();
		
		WelcomeController welcomeController = new WelcomeController(repository);
		welcomeController.startApplication();
	}

}

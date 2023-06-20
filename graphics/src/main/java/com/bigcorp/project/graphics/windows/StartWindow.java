package com.bigcorp.project.graphics.windows;

import java.util.ServiceLoader;

import com.bigcorp.project.business.services.JournalService;
import com.bigcorp.project.data.contract.AddressService;
import com.bigcorp.project.data.model.Journal;
import com.bigcorp.project.data.model.User;
import com.bigcorp.project.data.repository.UserRepositoryImpl;

/**
 * Simule une fenêtre de démarrage. Nécessite
 * UserRepository.
 */
public class StartWindow {

	private UserRepositoryImpl userRepository = new UserRepositoryImpl();

	public User displayHelloMessage() {
		User currentlyLoggedUser = userRepository.getCurrentlyLoggedUser();
		System.out.println("Hello, " + currentlyLoggedUser.getFirstName());
		
		return currentlyLoggedUser;
	}

	public static void main(String[] args) {
		StartWindow startWindow = new StartWindow();
		startWindow.displayHelloMessage();
		
		AddressService addressService = ServiceLoader
				.load(AddressService.class)
				.findFirst()
				.orElseThrow();
		
		System.out.println(addressService.getPostCode("3 rue des camélias, 92290 Roissy"));
		

		
		JournalService journalService = ServiceLoader
				.load(JournalService.class).findFirst().orElseThrow();
		Journal journal = new Journal();
		journal.setId(1l);
		journal.setTitle("Nouvelles neuves du nouveau monde");
		journalService.saveJournal(journal);
	}

}

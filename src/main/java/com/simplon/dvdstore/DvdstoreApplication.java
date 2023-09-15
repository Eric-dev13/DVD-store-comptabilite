package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

	//@Bean
	public CommandLineRunner demo(DvdRepository repository) {

		return (args) -> {
			// save a few customers
			repository.save(new DvdStoreRepositoryModel("Jack", "Bauer"));
			repository.save(new DvdStoreRepositoryModel("Chloe", "O'Brian"));
			repository.save(new DvdStoreRepositoryModel("Kim", "Bauer"));
			repository.save(new DvdStoreRepositoryModel("David", "Palmer"));
			repository.save(new DvdStoreRepositoryModel("Michelle", "Dessler"));

		};
	}

}

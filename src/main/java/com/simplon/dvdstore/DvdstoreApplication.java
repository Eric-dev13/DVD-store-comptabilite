package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DvdstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DvdModelRepository repository) {

		return (args) -> {
			// save a few customers
			repository.save(new DvdRepositoryModel("Jack", "Bauer"));
			repository.save(new DvdRepositoryModel("Chloe", "O'Brian"));
			repository.save(new DvdRepositoryModel("Kim", "Bauer"));
			repository.save(new DvdRepositoryModel("David", "Palmer"));
			repository.save(new DvdRepositoryModel("Michelle", "Dessler"));

		};
	}

}

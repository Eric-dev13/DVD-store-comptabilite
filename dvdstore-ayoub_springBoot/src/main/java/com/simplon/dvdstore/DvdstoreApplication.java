package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application démarré");
	}
}

package com.stuart;
import com.stuart.modul.Book;
import com.stuart.modul.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	// init bean to insert 3 books into h2 database.
	@Bean
	CommandLineRunner initDatabase(BookRepository repository){
		return args -> {
			repository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
			repository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
			repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
		};
	}

}
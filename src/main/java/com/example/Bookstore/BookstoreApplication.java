package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Tonttumetsä", "Riku", "234-22", "1994", 200);
			Book book2 = new Book("Leijonamieli", "Tonttu Tonttunen", "222-22", "1997", 12.4);
			Book book3 = new Book("Game of thrones", "Geoerge R. R. Martin", "234-22", "1978", 21);

			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
		};
	}

}

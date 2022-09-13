package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Horror"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("History"));

			brepository.save(
					new Book("Tonttumetsä", "Riku", "234-22", "1994", 200, crepository.findByName("Horror").get(0)));

			brepository.save(new Book("Leijonamieli", "Tonttu Tonttunen", "222-22", "1997", 12.4,
					crepository.findByName("Thriller").get(0)));

			brepository.save(new Book("Game of thrones", "George R. R. Martin", "234-22", "1978", 21,
					crepository.findByName("History").get(0)));

		};
	}

}

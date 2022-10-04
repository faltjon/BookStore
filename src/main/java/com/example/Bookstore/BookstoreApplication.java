package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.domain.Users;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository,
			UserRepository urepository) {
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

			Users user1 = new Users("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"testi@testi.com", "USER");
			Users user2 = new Users("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"testi1@testi1.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}

}

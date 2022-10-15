package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.domain.Users;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTests {

	@Autowired
	private BookRepository brepository;

	@Autowired
	private CategoryRepository crepository;

	@Autowired
	private UserRepository urepository;

	@Test
	public void createNewBook() {
		Book book = new Book("TestBook", "TestAuthor", "11-1-111", "111-111", 11.1, new Category("TestCategory"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = brepository.findByAuthor("Riku");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Tonttumetsä");
	}

	@Test
	public void deleteNewBook() {
		List<Book> books = brepository.findByAuthor("Riku");
		Book book = books.get(0);
		brepository.delete(book);
		List<Book> newBooks = brepository.findByAuthor("Riku");
		assertThat(newBooks).hasSize(0);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("TestCategory");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

	@Test
	public void findByCategory() {
		List<Category> categories = crepository.findByName("Horror");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
	}

	@Test
	public void deleteNewCategory() {
		List<Category> categories = crepository.findByName("Horror");
		Category category = categories.get(0);
		crepository.delete(category);
		List<Category> newCategory = crepository.findByName("Horror");
		assertThat(newCategory).hasSize(0);
	}

	@Test
	public void createNewUser() {
		Users user = new Users("TestUser", "TestPassword", "testemail@test.com", "ADMIN");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void findByUsernameReturnEmail() {
		Users users = urepository.findByUsername("user");
		assertThat(users.getUsername().equals("user"));
	}

	@Test
	public void deleteUser() {
		Users user = urepository.findByUsername("user");
		urepository.delete(user);
		Users newUser = urepository.findByUsername("user");
		assertThat(newUser).isNull();
	}

}

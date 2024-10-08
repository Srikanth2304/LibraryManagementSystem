package com.application.courselibrary;

import com.application.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
		System.out.println("running");
	}

	@Bean
	public CommandLineRunner intialCreate(BookService bookService){
		return (args) ->{
			// Book 1
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

// Book 2
			Book book2 = new Book("XYZ", "Another Book", "My second book");
			Author author2 = new Author("Test name2", "Another description");
			Category category2 = new Category("Technology books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

// Book 3
			Book book3 = new Book("DEF", "Third Book", "My third book");
			Author author3 = new Author("Test name3", "Yet another description");
			Category category3 = new Category("Science books");
			Publisher publisher3 = new Publisher("Third Publisher");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

		};

	}
}

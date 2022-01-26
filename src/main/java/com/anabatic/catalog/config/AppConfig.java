package com.anabatic.catalog.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.anabatic.catalog.domain.Author;
import com.anabatic.catalog.domain.Book;
import com.anabatic.catalog.repository.BookRepository;
import com.anabatic.catalog.repository.impl.BookRepositoryImpl;


@Configuration
public class AppConfig {
	
//	@Bean
//	public Author author() {
//		return new Author(1l,  "Cristiano Ronaldo", null, false);
//	}
//	
//	@Bean
//	public Book book1(Author author) {
//		Book book = new Book();
//		book.setId(1L);
//		book.setTitle("Cristiano Ronaldo");
//		book.setDescription("Best ronaldo");
//		book.setAuthor(author);
//		return book;
//	}
//	
//	@Bean
//	public Book book2(Author author) {
//		Book book = new Book();
//		book.setId(2L);
//		book.setTitle("Cristiano Ronaldo");
//		book.setDescription("Real madrid season");
//		book.setAuthor(author);
//		return book;
//	}
////	
//	@Bean
//	public BookRepository bookRepository(Book book1, Book book2) {
//		Map<Long, Book> bookMap = new HashMap<Long, Book>();
//		bookMap.put(1L, book1);
//		bookMap.put(2L, book2);
//		
//		BookRepositoryImpl bookRepository = new BookRepositoryImpl();
//		bookRepository.setBookMap(bookMap);
//		
//		return bookRepository;
//		
//	}
//	
////	@Bean
////	public BookService bookService(BookRepository bookRepository) {
////		return new BookServiceImpl(bookRepository);
////		
////	}
//
//}



}


package com.anabatic.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anabatic.catalog.domain.Author;
import com.anabatic.catalog.domain.Book;
import com.anabatic.catalog.domain.Category;
import com.anabatic.catalog.domain.Publisher;
import com.anabatic.catalog.dto.BookCreateRequestDTO;
import com.anabatic.catalog.dto.BookDetailResponseDTO;
import com.anabatic.catalog.dto.BookListResponseDTO;
import com.anabatic.catalog.dto.BookUpdateRequestDTO;
import com.anabatic.catalog.dto.ResultPageResponseDTO;
import com.anabatic.catalog.exception.BadRequestException;
import com.anabatic.catalog.repository.BookRepository;
import com.anabatic.catalog.service.AuthorService;
import com.anabatic.catalog.service.BookService;
import com.anabatic.catalog.service.CategoryService;
import com.anabatic.catalog.service.GreetingService;
import com.anabatic.catalog.service.PublisherService;
import com.anabatic.catalog.util.PaginationUtil;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService{
	
	
	private final BookRepository bookRepository;

	private final AuthorService authorService;
	
	private final CategoryService categoryService;

	private final PublisherService publisherService;
	@Override
	public BookDetailResponseDTO findBookDetailById(String bookId) {
		Book book = bookRepository.findBySecureId(bookId)
				.orElseThrow(()->new BadRequestException("book_id.invalid"));
		BookDetailResponseDTO dto = new BookDetailResponseDTO();
		dto.setBookId(book.getSecureId());
		dto.setCategories(categoryService.constructDTO(book.getCategories()));
		dto.setAuthors(authorService.constructDTO(book.getAuthors()));
		dto.setPublisher(publisherService.constructDTO(book.getPublisher()));
		dto.setBookTitle(book.getTitle());
		dto.setBookDescription(book.getDescription());
		return dto;
	}



	@Override
	public List<BookDetailResponseDTO> findBookListDetail() {
		List<Book> books = bookRepository.findAll();
		
		return books.stream().map((b)->{
			BookDetailResponseDTO dto = new BookDetailResponseDTO();
//			dto.setAuthorName(b.getAuthor().getName());
			dto.setBookDescription(b.getDescription());
//			dto.setBookId(b.getId());
			dto.setBookTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}



	@Override
	public void createNewBook(BookCreateRequestDTO dto) {
		List<Author> authors = authorService.findAuthors(dto.getAuthorIdList());
		List<Category> categories = categoryService.findCategories(dto.getCategoryList());
		Publisher publisher = publisherService.findPublisher(dto.getPublisherId());
		Book book = new Book();
		book.setAuthors(authors);
		book.setCategories(categories);
		book.setPublisher(publisher);
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		bookRepository.save(book);
		
	}



	@Override
	public void updateBook(String bookId, BookUpdateRequestDTO dto) {
		//get book from repository
		Book book = bookRepository.findBySecureId(bookId)
				.orElseThrow(()->new BadRequestException("book_id.invalid"));
		//UPDATE
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		//SAVE
		bookRepository.save(book);
		
	}



	@Override
	public void deleteBook(String bookId) {
		Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("invalid.bookId"));
		bookRepository.delete(book);
		
	}



	@Override
	public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer page, Integer limit, String sortBy,
			String direction, String publisherName, String bookTitle, String authorName) {
		Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
		Pageable pageable = PageRequest.of(page, limit, sort);
		Page<Book> pageResult = bookRepository.findBookList(bookTitle, publisherName, pageable);
		List<BookListResponseDTO> dtos = pageResult.stream().map(b->{
			BookListResponseDTO dto = new BookListResponseDTO();
			dto.setAuthorNames(b.getAuthors().stream().map(a->a.getName()).collect(Collectors.toList()));
			dto.setCategoryCodes(b.getCategories().stream().map(c->c.getCode()).collect(Collectors.toList()));
			dto.setTitle(b.getTitle());
			dto.setPublisherName(b.getPublisher().getName());
			dto.setDescription(b.getDescription());
			dto.setId(b.getSecureId());
			return dto;
		}).collect(Collectors.toList());
		return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
	}





//	public BookRepository getBookRepository() {
//		return bookRepository;
//	}
//
//	public void setBookRepository(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}

}

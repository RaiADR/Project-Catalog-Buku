package com.anabatic.catalog.service;

import java.util.List;

import com.anabatic.catalog.domain.Book;
import com.anabatic.catalog.dto.BookCreateRequestDTO;
import com.anabatic.catalog.dto.BookDetailResponseDTO;
import com.anabatic.catalog.dto.BookListResponseDTO;
import com.anabatic.catalog.dto.BookSaveRequestDTO;
import com.anabatic.catalog.dto.BookUpdateRequestDTO;
import com.anabatic.catalog.dto.ResultPageResponseDTO;

public interface BookService {

	public BookDetailResponseDTO findBookDetailById(String bookId);

	public List<BookDetailResponseDTO> findBookListDetail();

	public void createNewBook(Long bookId, BookCreateRequestDTO dto);

	public void updateBook(String bookId, BookUpdateRequestDTO dto);

	public void deleteBook(String bookId);
	
	public void deleteBookById(Long id);

	public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer page, Integer limit, String sortBy,
			String direction, String publisherName, String bookTitle, String authorName);

	public List<BookDetailResponseDTO> getAllBooks();

	public void saveBook(BookSaveRequestDTO dto);
	
	public void getBookById(String id);
	
	public void updateBookById(String bookId, BookSaveRequestDTO dto);

	void updateBookById(BookUpdateRequestDTO dto);

}

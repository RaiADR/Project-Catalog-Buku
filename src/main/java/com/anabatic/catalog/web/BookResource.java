package com.anabatic.catalog.web;

import java.net.URI;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anabatic.catalog.dto.BookCreateRequestDTO;
import com.anabatic.catalog.dto.BookDetailResponseDTO;
import com.anabatic.catalog.dto.BookListResponseDTO;
import com.anabatic.catalog.dto.BookUpdateRequestDTO;
import com.anabatic.catalog.dto.ResultPageResponseDTO;
import com.anabatic.catalog.service.BookService;
import com.anabatic.catalog.service.GreetingService;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {
	
	private static final String BookId = null;
	private final BookService bookService;
	
	@GetMapping("/v1/book/{bookId}")
	public ResponseEntity<BookDetailResponseDTO> findBookDetailById(@PathVariable("bookId") String id) {
		StopWatch stopwatch = new StopWatch();
		log.info("Start findbook detail "+id);
		stopwatch.start();
		BookDetailResponseDTO result = bookService.findBookDetailById(id);
		log.info("Finish findbook detail. execution time = {} ",stopwatch.getTotalTimeMillis());
		return ResponseEntity.ok(result);
	}
	
	//GET BOOK LIST ->
	//1. JUDUL BUKU
	//2. NAMA PENERBIT //TABLE PUBLISHER
	//3. PENULIS // TBABLE AUTHOR
	
	@GetMapping("/v1/book")
	public ResponseEntity<ResultPageResponseDTO<BookListResponseDTO>> findBookList( 
			@RequestParam(name="page", required = true, defaultValue = "0") Integer page,
			@RequestParam(name="limit", required = true, defaultValue = "10") Integer limit,
			@RequestParam(name="sortBy", required = true, defaultValue = "title") String sortBy,
			@RequestParam(name="direction", required = true, defaultValue = "asc") String direction,
			@RequestParam(name="bookTitle", required = false, defaultValue = "")  String bookTitle,
			@RequestParam(name="authorName", required = false, defaultValue = "")  String authorName,
			@RequestParam(name="publisherName", required = false, defaultValue = "") String publisherName){
		return ResponseEntity.ok().body(bookService.findBookList(page, limit, sortBy, direction, publisherName, bookTitle, authorName));
	}
	
	
	
	
	@PostMapping("/v1/book")
	public ResponseEntity<Void> createNewBook(@RequestBody BookCreateRequestDTO dto){
		Long bookId = null;
		bookService.createNewBook(bookId, dto);
		return ResponseEntity.created(URI.create("/v1/book")).build();
		}
	
//	@GetMapping("/v1/book")
//	public ResponseEntity<List<BookDetailResponseDTO>> findBookList(){
//		return ResponseEntity.ok().body(bookService.findBookListDetail());
//		
//	}
	
	// PUT BOOK
	@PutMapping("/v1/book/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId, @RequestBody BookCreateRequestDTO dto){
		bookService.createNewBook(bookId, dto);
		return ResponseEntity.ok().build();
	}
	
	// DEL BOOK
	@DeleteMapping("/v1/book/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") String bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
}

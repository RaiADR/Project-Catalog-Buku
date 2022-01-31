package com.anabatic.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anabatic.catalog.domain.Book;
import com.anabatic.catalog.dto.BookCreateRequestDTO;
import com.anabatic.catalog.dto.BookSaveRequestDTO;

public interface BookRepository extends JpaRepository<Book, Long>{

//	
//	public Optional<Book> findById(Long id);
	
	//SQL  :select b from book b where b.secure_id = :id
	//JPQL :select b FROM Book b WHERE b.secureId=:id

	public Optional<Book> findBySecureId(String Id);
//	
	
	
	@Query("SELECT DISTINCT b FROM Book b "
			+ "INNER JOIN Publisher p ON p.id = b.publisher.id "
			+ "JOIN b.authors ba "
			+ "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',:publisherName,'%'))"
			+ " AND LOWER(b.title) LIKE LOWER(CONCAT('%',:bookTitle,'%'))"
			+ " AND LOWER(ba.name) LIKE LOWER(CONCAT('%',:authorName,'%'))")
	public Page<Book> findBookList(String bookTitle, String publisherName, String authorName, Pageable pageable);
//	public List<Book> findAll();
//	
//	public void save(Book book);
////	
//	public void update(Book book);
//	
//	public void delete(Long bookId);





}

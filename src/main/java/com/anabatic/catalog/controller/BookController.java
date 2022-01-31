package com.anabatic.catalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anabatic.catalog.domain.Book;
import com.anabatic.catalog.dto.AuthorCreateRequestDTO;
import com.anabatic.catalog.dto.AuthorResponseDTO;
import com.anabatic.catalog.dto.BookCreateRequestDTO;
import com.anabatic.catalog.dto.BookDetailResponseDTO;
import com.anabatic.catalog.dto.BookSaveRequestDTO;
import com.anabatic.catalog.dto.BookUpdateRequestDTO;
import com.anabatic.catalog.dto.CategoryListResponseDTO;
import com.anabatic.catalog.dto.PublisherListResponseDTO;
import com.anabatic.catalog.service.AuthorService;
import com.anabatic.catalog.service.BookService;
import com.anabatic.catalog.service.CategoryService;
import com.anabatic.catalog.service.PublisherService;
import com.anabatic.catalog.service.impl.AuthorServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;
	private final AuthorService authorService;
	private final PublisherService publisherService;
	private final CategoryService categoryService;
	
//	DISPLAY ALL BOOKS
	@GetMapping("/list")
	public String viewHomePage(Model model) {
		
		List<BookDetailResponseDTO> books = bookService.getAllBooks();
//		List<AuthorResponseDTO> authors = authorService.getAllAuthors();
		model.addAttribute("books",books);
//		model.addAttribute("authors",authors);
		return "book/list";
	}
	
//	SHOW ADD BOOK FORM
	@GetMapping("/addBook")
	public String showAddBookForm(Model model) {
		BookSaveRequestDTO dto = new BookSaveRequestDTO();
		List<AuthorResponseDTO> authors = authorService.getAllAuthors();
		List<CategoryListResponseDTO> categories = categoryService.getAllCategories();
		List<PublisherListResponseDTO> publishers = publisherService.getAllCategories();
		model.addAttribute("bookCreateDTO", dto);
		model.addAttribute("authors",authors);
		model.addAttribute("categories",categories);
		model.addAttribute("publishers",publishers);
		return "book/addBook";
	}
//	
	@PostMapping("/addBook")
	public String saveBook(@ModelAttribute("BookCreateDTO") @Valid BookSaveRequestDTO dto, BindingResult bindingResult, 
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("bookCreateDTO", dto);
			return "/book/addBook"; 
		}
		// save book to database
		bookService.saveBook(dto);
		return "redirect:/book/list";
	}
	
	@GetMapping("/{id}")
	public String showUpdateBookForm(@PathVariable (value = "id")String id,  Model model) {
		//	get book

		BookDetailResponseDTO book = bookService.findBookDetailById(id);
		List<AuthorResponseDTO> authors = authorService.getAllAuthors();
		List<CategoryListResponseDTO> categories = categoryService.getAllCategories();
		List<PublisherListResponseDTO> publishers = publisherService.getAllCategories();
		model.addAttribute("bookCreateDTO", book);
		model.addAttribute("authors",authors);
		model.addAttribute("categories",categories);
		model.addAttribute("publishers",publishers);

		return "book/updateBook";
//		return ResponseEntity.ok(book);
//		
	}
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable (value = "id")Long id) {
//		call delete method
		bookService.deleteBookById(id);
		return "redirect:/book/list";
	}

	@PostMapping("/addAuthor")
	public ResponseEntity<@Valid List<AuthorCreateRequestDTO>> saveauthor(@ModelAttribute("AuthorCreateRequestDTO") @Valid List<AuthorCreateRequestDTO> dto, BindingResult bindingResult, 
			Errors errors,
			Model model) {
//		if(errors.hasErrors()) {
//			model.addAttribute("AuthorCreateRequestDTO", dto);
//			return "/book/addAuthor"; 
//		}
//		// save book to database
//		authorService.createNewAuthor(dto);
//		return "redirect:/book/list";
		return ResponseEntity.ok(dto);
	}
	
//	@PostMapping("/addCategory")
//	public String saveCategory(@ModelAttribute("AdressCreateRequestDTO") @Valid AdressCreateRequestDTO dto, BindingResult bindingResult, 
//			Errors errors,
//			Model model) {
//		if(errors.hasErrors()) {
//			model.addAttribute("bookCreateDTO", dto);
//			return "/book/addCategory"; 
//		}
//		// save book to database
//		categoryService.createAndUpdateCategory(dto);
//		return "redirect:/book/list";
//	}
//	
//	@PostMapping("/addPublisher")
//	public String savePublisher(@ModelAttribute("BookCreateDTO") @Valid BookSaveRequestDTO dto, BindingResult bindingResult, 
//			Errors errors,
//			Model model) {
//		if(errors.hasErrors()) {
//			model.addAttribute("bookCreateDTO", dto);
//			return "/book/addPublisher"; 
//		}
//		// save book to database
//		publisherService.createPublisher(dto);
//		return "redirect:/book/list";
//	}

}

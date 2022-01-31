package com.anabatic.catalog.service;

import java.util.List;

import com.anabatic.catalog.domain.Author;
import com.anabatic.catalog.dto.AuthorCreateRequestDTO;
import com.anabatic.catalog.dto.AuthorResponseDTO;
import com.anabatic.catalog.dto.AuthorUpdateRequestDTO;

public interface AuthorService {
	
	public AuthorResponseDTO findAuthorById(String id);
	
	public void createNewAuthor(List<AuthorCreateRequestDTO> dto);
	
	public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);
	
	public void deleteAuthor(String authorId);
	
	public List<Author> findAuthors(List<String> authorIdList);
	
	public List<AuthorResponseDTO> constructDTO(List<Author> authors);

	public List<Author> findAll();
	
	public List<AuthorResponseDTO> getAllAuthors();
}

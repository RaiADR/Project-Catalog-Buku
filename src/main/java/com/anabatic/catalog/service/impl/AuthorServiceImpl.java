package com.anabatic.catalog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anabatic.catalog.domain.Address;
import com.anabatic.catalog.domain.Author;
import com.anabatic.catalog.dto.AuthorCreateRequestDTO;
import com.anabatic.catalog.dto.AuthorResponseDTO;
import com.anabatic.catalog.dto.AuthorUpdateRequestDTO;
import com.anabatic.catalog.exception.BadRequestException;
import com.anabatic.catalog.exception.ResourceNotFoundException;
import com.anabatic.catalog.repository.AuthorRepository;
import com.anabatic.catalog.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	@Override
	public AuthorResponseDTO findAuthorById(String id) {
		// TODO Auto-generated method stub
		// 1. fetch data from database
		Author author = authorRepository.findBySecureId(id)
				.orElseThrow(() -> new ResourceNotFoundException("invalid.authorId"));
		// 2. author -> authorrespond dto
		AuthorResponseDTO dto = new AuthorResponseDTO();
		dto.setAuthorName(author.getName());
		dto.setBirthDate(author.getBirthDate().toEpochDay());
		return dto;
	}

	@Override
	public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {

		List<Author> authors = dtos.stream().map((dto) -> {
			Author author = new Author();
			author.setName(dto.getAuthorName());
			author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
			List<Address> addresses = dto.getAddresses().stream().map(a -> {
				Address address = new Address();
				address.setCityName(a.getCityName());
				address.setStreetName(a.getStreetName());
				address.setZipCode(a.getZipCode());
				address.setAuthor(author);
				return address;
			}).collect(Collectors.toList());
			author.setAddresses(addresses);
			return author;
		}).collect(Collectors.toList());

		authorRepository.saveAll(authors);

	}

	@Override
	public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto) {
		// TODO Auto-generated method stub
		Author author = authorRepository.findBySecureId(authorId)
				.orElseThrow(() -> new BadRequestException("invalid.authorId"));
		Map<Long, Address> addressMap = author.getAddresses().stream().map(a->a).collect(Collectors.toMap(Address::getId, Function.identity()));
		List<Address> addresses= dto.getAddresses().stream().map(a->{
			Address address = addressMap.get(a.getAddressId());
			address.setCityName(a.getCityName());
			address.setStreetName(a.getStreetName());
			address.setZipCode(a.getZipCode());
			return address;
		}).collect(Collectors.toList());
		author.setAddresses(addresses);
		author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
		author.setBirthDate(
				dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(String authorId) {
		// 1. select data
		// 2. delete
		// or langsung delete (hard felete)
//		authorRepository.deleteById(authorId);
		Author author = authorRepository.findBySecureId(authorId)
				.orElseThrow(() -> new BadRequestException("invalid.authorId"));
		authorRepository.delete(author);
		// soft delete
		// 1.select data deleted=false
//		Author author = authorRepository.findById(authorId)
//			.orElseThrow(() -> new BadRequestException("invalid authorId"));
//		//2.update deleted=true
//		author.setDeleted(Boolean.TRUE);
//		authorRepository.save(author);
	}

	@Override
	public List<Author> findAuthors(List<String> authorIdList) {
		List<Author> authors = authorRepository.findBySecureIdIn(authorIdList);
		if (authors.isEmpty())
			throw new BadRequestException("author cannot be emtpy");
		return authors;
	}

	@Override
	public List<AuthorResponseDTO> constructDTO(List<Author> authors) {

		return authors.stream().map((a) -> {
			AuthorResponseDTO dto = new AuthorResponseDTO();
			dto.setAuthorName(a.getName());
			dto.setBirthDate(a.getBirthDate().toEpochDay());
			return dto;
		}).collect(Collectors.toList());
	}

}

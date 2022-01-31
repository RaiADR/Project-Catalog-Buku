package com.anabatic.catalog.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anabatic.catalog.domain.Author;
import com.anabatic.catalog.domain.Publisher;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookSaveRequestDTO implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2648843495922513055L;
	
	private Long id;

	private String bookSecureId;

	@NotBlank(message = "tidak boleh kosong !")
	public String bookTitle;
	

	private List<String> authorId;
	
	private List<String> category;
	
	@NotEmpty
	private List<String> categoryCode;
	

	private String publisherId;
	
//	@JsonProperty("synopsis")
	private String description;
	

}

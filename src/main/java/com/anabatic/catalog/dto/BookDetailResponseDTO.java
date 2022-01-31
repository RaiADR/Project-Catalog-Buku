package com.anabatic.catalog.dto;

import java.io.Serializable;
import java.util.List;

import com.anabatic.catalog.domain.Publisher;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDetailResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244720683307084627L;
	
	private Long id;

	private String bookSecureId;
	
	private List<String> authorId;
	
	private List<String> authorsNames;
	
	private List<String> category;
	
	private List<String> categoryCode;
	
	private String publisherName;
	
	private String bookTitle;
	
	private String description;
	
	private String publisherId;
	
	private String categoryName;
	
	private String categoryId;
	
	

	
	

}

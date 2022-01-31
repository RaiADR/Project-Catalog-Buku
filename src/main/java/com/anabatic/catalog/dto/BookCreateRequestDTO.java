package com.anabatic.catalog.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookCreateRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6969091067725000624L;

	private Long id;
	
	@NotBlank(message = "tidak boleh kosong !")
	public String bookTitle;
	
	@NotEmpty
	private List<String> authorIdList;
	
	@NotEmpty
	private List<String> categoryList;
	
	@NotBlank
	private String publisherId;
	
	@JsonProperty("synopsis")
	private String description;
	

}

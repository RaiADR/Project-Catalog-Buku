package com.anabatic.catalog.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookUpdateRequestDTO {
	@NotBlank(message = "tidak boleh kosong !")
	public String bookTitle;
	

	
	@JsonProperty("synopsis")
	private String description;
}

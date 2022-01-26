package com.anabatic.catalog.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuthorCreateRequestDTO {
	
	@NotBlank
	private String authorName;
	
	@NotNull
	private Long birthDate;
	
	private List<AddressCreateRequestDTO> addresses;

}

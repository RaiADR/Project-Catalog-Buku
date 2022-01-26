package com.anabatic.catalog.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryCreateUpdateRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8094837192081126959L;

	@NotBlank
	private String code;
	
	@NotBlank
	private String name;
	
	private String description;

}

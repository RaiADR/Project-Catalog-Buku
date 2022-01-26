package com.anabatic.catalog.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryListResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1284962157556466864L;
	
	private String code;
	
	private String name;
	
	private String description;

}

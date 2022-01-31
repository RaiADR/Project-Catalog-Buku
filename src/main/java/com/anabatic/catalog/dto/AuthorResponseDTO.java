package com.anabatic.catalog.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuthorResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912435430073429363L;
	private String authorName;
	private Long birthDate;
	private String authorSecureId;
}

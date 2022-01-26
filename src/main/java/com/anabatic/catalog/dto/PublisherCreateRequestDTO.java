package com.anabatic.catalog.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.anabatic.catalog.annotation.LogThisArg;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@LogThisArg
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2264370289125784518L;

	@NotBlank
	private String publisherName;
	
	@NotBlank
	private String companyName;
	
	private String address;

}

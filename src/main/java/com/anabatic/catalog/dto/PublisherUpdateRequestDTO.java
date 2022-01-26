package com.anabatic.catalog.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherUpdateRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4477154542114590195L;

	private String publisherName;

	private String companyName;
	
	private String address;

}

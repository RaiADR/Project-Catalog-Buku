package com.anabatic.catalog.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PublisherListResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3815279730252246604L;

	private String publisherId;
	
	private String publisherName;
	
	private String companyName;

}

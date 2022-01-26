package com.anabatic.catalog.service;

import com.anabatic.catalog.dto.PublisherCreateRequestDTO;
import com.anabatic.catalog.dto.PublisherUpdateRequestDTO;
import com.anabatic.catalog.domain.Publisher;
import com.anabatic.catalog.dto.*;

public interface PublisherService {
	
	public void createPublisher(PublisherCreateRequestDTO dto);
	
	public Publisher findPublisher(String publisherId);
	
	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit,String sortBy, String direction, String publisherName);
	
	public PublisherResponseDTO constructDTO(Publisher publisher);
}

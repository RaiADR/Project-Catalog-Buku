package com.anabatic.catalog.service;

import java.util.List;

import com.anabatic.catalog.domain.Publisher;
import com.anabatic.catalog.dto.*;

public interface PublisherService {
	
	public void createPublisher(PublisherCreateRequestDTO dto);
	
	public Publisher findPublisher(String publisherId);
	
	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit,String sortBy, String direction, String publisherName);
	
	public PublisherResponseDTO constructDTO(Publisher publisher);

	public List<Publisher> findAll();

	public List<PublisherListResponseDTO> getAllCategories();
}

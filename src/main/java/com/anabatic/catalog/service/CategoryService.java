package com.anabatic.catalog.service;

import java.util.List;

import com.anabatic.catalog.domain.Category;
import com.anabatic.catalog.dto.BookDetailResponseDTO;
import com.anabatic.catalog.dto.CategoryCreateUpdateRequestDTO;
import com.anabatic.catalog.dto.CategoryListResponseDTO;
import com.anabatic.catalog.dto.ResultPageResponseDTO;

public interface CategoryService {
	
	public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages,
			Integer limit, String sortBy, String direction, String categoryName);
	
	public List<Category> findCategories(List<String> categoryCodeList);
	
	public List<CategoryListResponseDTO> constructDTO(List<Category> categories);
	
	public List<CategoryListResponseDTO> getAllCategories();

}

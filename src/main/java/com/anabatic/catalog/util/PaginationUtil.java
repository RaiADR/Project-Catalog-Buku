package com.anabatic.catalog.util;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.anabatic.catalog.dto.ResultPageResponseDTO;

public class PaginationUtil {
	
	public static <T> ResultPageResponseDTO<T> createResultPageDTO(List<T> dtos, Long totalElement, Integer pages){
		ResultPageResponseDTO<T> result = new ResultPageResponseDTO<T>();
		result.setPages(pages);
		result.setElements(totalElement);
		result.setResult(dtos);
		return result;
	}
	
	public static Sort.Direction getSortBy(String sortBy){
		if(sortBy.equals("asc")) {
			return Sort.Direction.ASC;
		} else {
			return Sort.Direction.DESC;
		}
	}

}

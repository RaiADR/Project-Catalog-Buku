package com.anabatic.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anabatic.catalog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	//method name convension
	//find+keyword
	//sql - > select * from Author a where a.id=1=authurId
	public Optional<Author> findById(Long id);
	
	public List<Author> findBySecureIdIn(List<String> authorIdList);
	public Optional<Author> findBySecureId(String id);
	
	//where id= :id AND deleted=false
	public Optional<Author> findByIdAndDeletedFalse(Long id);
	
	//sql -> select a from author a where a.name like:authorName
	public List<Author> findByNameLike(String authorName);
	

}

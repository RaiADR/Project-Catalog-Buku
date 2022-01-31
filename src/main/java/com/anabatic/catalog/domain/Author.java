package com.anabatic.catalog.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="author")

//@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?") 
//@Where(clause = "deleted=false")

public class Author extends AbstractBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8611365511872356893L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq")
	private long id;
	

	
	
	@Column(name = "author_name", nullable=false, columnDefinition = "varchar(300)")
	private String name;
	
	@Column(name = "birth_date", nullable=false)
	private LocalDate birthDate;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Address> addresses;

}

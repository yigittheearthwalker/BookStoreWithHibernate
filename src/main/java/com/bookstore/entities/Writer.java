package com.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "writer", uniqueConstraints = {

		@UniqueConstraint(name = "writer_name_constraint", columnNames = {"full_name"})

})
public class Writer extends BaseObject{
	
	@Column(name = "number_of_books")
	private Integer numberOfBooks;

	public Integer getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(Integer numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}
	
	
}

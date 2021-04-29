package com.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "publisher", uniqueConstraints = {

		@UniqueConstraint(name = "publisher_name_constraint", columnNames = {"full_name"})

})
public class Publisher extends BaseObject{
	
	@Column(name = "number_of_books")
	private Integer numberOfBooks;

	public Integer getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(Integer numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}
	
}

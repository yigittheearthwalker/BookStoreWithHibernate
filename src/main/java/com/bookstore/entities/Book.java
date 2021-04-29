package com.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = {

		@UniqueConstraint(name = "book_name_constraint", columnNames = {"full_name"})

}
		)
public class Book extends BaseObject{
	
	@Column(name = "release_year")
	private Integer releaseYear;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn(name = "writer_id")
	private Writer writer;

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
		publisher.setNumberOfBooks(publisher.getNumberOfBooks() + 1);
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
		writer.setNumberOfBooks(writer.getNumberOfBooks() + 1);
	}
	
}

package com.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseObject {
	
	@Id
	@GenericGenerator(name = "custom_id", strategy = "com.bookstore.utils.CustomIDGenerator")
	@GeneratedValue(generator = "custom_id", strategy = GenerationType.SEQUENCE)
	private String id;
	
	@Column(name = "full_name")
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}


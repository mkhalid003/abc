package com.abc.abcdemoservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usermodel")
public class UserModel {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public UserModel() {

	}

	public UserModel(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + "]";
	}
	

}
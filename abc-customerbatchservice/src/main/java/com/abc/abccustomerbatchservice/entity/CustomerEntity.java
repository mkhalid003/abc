package com.abc.abccustomerbatchservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table(name = "customers")
@Data
public class CustomerEntity implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long customer_id;
	@Column
	private String firstName;
	@Column
    private String lastName;
	
//    @OneToMany(mappedBy = "customerEntity")
//    private List<OrderEntity> orders = new ArrayList<>();
  
}
 

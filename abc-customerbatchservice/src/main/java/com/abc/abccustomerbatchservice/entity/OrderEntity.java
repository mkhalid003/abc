package com.abc.abccustomerbatchservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
 
@Entity 
@Data
@Table(name = "orders")
public class OrderEntity implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long order_id;
	@Column
	private String id; 
	@Column
	private Date Date; 
	@Column
	private BigDecimal amount; 
	@Column
	private String description; 
	@Column
	private Boolean completed;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "customer_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private CustomerEntity customerEntity;

}

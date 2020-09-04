package com.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String product;
	String product_make;
	String product_model;
	String serial_no;
	String battery_serial_no;
	String other_detail;

	@OneToOne(mappedBy = "product")
	 @ToString.Exclude
    private Mapping mapping;
	
}

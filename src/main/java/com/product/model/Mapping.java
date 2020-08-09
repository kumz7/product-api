package com.product.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mapping")
public class Mapping implements Serializable{ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_customer", nullable=true)
	Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_estimation", referencedColumnName = "id")
	Estimation estimation; 

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_issue", referencedColumnName = "id")
	Issue issue;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product", referencedColumnName = "id")
	Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ticket", referencedColumnName = "id")
	Ticket ticket;

}

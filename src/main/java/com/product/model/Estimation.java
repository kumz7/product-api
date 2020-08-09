package com.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estimation")
public class Estimation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String estimation_quote;
	String service_charge;
	String advance_amount;	
	@OneToOne(mappedBy = "estimation")
    private Mapping mapping;
}

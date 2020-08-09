package com.product.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

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
@Table(name="customer")
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String name;
	String mail;
	String contact;
	String altcontact;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="customer",orphanRemoval = true)
    private List<Mapping> mapping; 


}

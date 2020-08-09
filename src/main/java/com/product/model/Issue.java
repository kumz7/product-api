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
@Table(name="issue")
public class Issue implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String issue;
	String issue_description;
	String cpu;
	String ram;
	String hdd;
	boolean adpt;
	boolean odd;
	boolean p_cord;
	boolean bag;
	@OneToOne(mappedBy = "issue")
    private Mapping mapping;
}

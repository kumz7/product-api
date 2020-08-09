package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Customer;
import com.product.model.Issue;
import com.product.model.Product;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {

	
}
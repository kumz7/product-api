package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Issue;


public interface IssueService {
	public Issue storeIssue(Issue Issue);
	public Optional<Issue> fetchIssueById(Long id);
	public void deleteIssueById(Long id);

}

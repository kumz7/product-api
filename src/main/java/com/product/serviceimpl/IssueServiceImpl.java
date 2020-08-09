package com.product.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Issue;
import com.product.repository.IssueRepository;
import com.product.service.IssueService;

@Service("IssueService")
public class IssueServiceImpl implements IssueService{
	@Autowired
	IssueRepository repository;
	
	@Override
	public Issue storeIssue(Issue Issue) { 
		return repository.save(Issue);
	}

	@Override
	public Optional<Issue> fetchIssueById(Long id) {
 		return repository.findById(id);
	}
	
	@Override
	public void deleteIssueById(Long id) {
 		repository.deleteById(id);
	}

}

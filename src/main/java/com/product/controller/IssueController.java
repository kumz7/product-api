package com.product.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Issue;
import com.product.service.IssueService;


@RestController
public class IssueController { 

	@Autowired
	IssueService service;
	
	@PostMapping
	@RequestMapping("/issue")
	public Issue storeIssue(@RequestBody Issue Issue) {
		return service.storeIssue(Issue); 
	}
	/*
	 * Key may contain name/number/Issue id
	 */
	@GetMapping
	@RequestMapping("/issue/{id}")
	public Optional<Issue> fetch(@PathVariable Long id) { 
		return service.fetchIssueById(id); 
	}
}

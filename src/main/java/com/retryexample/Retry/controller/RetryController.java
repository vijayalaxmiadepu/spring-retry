package com.retryexample.Retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retryexample.Retry.service.RetryService;

@RestController
public class RetryController {
	
	@Autowired
	RetryService retryService;

	@PostMapping("/retrySample/{name}/demo")
	public String retrySample(@PathVariable("name") String name) throws Exception {
		return retryService.retryExample(name);
	}
}

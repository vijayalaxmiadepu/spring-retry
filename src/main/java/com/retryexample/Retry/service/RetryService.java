package com.retryexample.Retry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 3000))
	public String retryExample(String name) throws Exception {
		System.out.println("Executing retryExample");
		if(name.equals("ERROR"))
			throw new Exception("Throwing exception for retry...");
		return "Hello "+name;
	}
	
	@Recover
	public String fallbackMessage(String name) {
		return name+ " Could not say hello, Try next time";
	}

}

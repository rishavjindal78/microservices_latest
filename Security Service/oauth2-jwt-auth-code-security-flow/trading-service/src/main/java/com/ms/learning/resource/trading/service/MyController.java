package com.ms.learning.resource.trading.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/trade")
	@PreAuthorize("#oauth2.hasScope('read')")
	public String securedUser() {
		return "Trade is secured";
	}

}	

package com.ps.resource.server;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/user")
	@PreAuthorize("#oauth2.hasScope('read')")
	public String securedUser() {
		return "User is secured";
	}

}

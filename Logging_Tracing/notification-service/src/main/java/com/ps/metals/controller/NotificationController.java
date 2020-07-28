package com.ps.metals.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trades")
public class NotificationController {

	@GetMapping("/notify")
	public <T> ResponseEntity<String> sendNotification() {
		return new ResponseEntity<String>("Notification sent successfully",HttpStatus.OK);
	}
}

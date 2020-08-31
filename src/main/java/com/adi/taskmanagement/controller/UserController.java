package com.adi.taskmanagement.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/ping")
	public String ping() {
		return "Task Manager reached "+ new Date().getTime();
	}
}

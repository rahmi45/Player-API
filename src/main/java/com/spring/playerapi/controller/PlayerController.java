package com.spring.playerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PlayerController {
	
	@GetMapping(value = "/data")
	//http://localhost:8088/playerapi/api/data
	public String getData() {
		return "myData";
	}
}

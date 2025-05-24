package com.bridgelabz.addressbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressBookController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hellloooooooo";
	}

}

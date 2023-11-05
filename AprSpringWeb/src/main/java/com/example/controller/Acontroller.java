package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.Acommand;

@Controller
@RequestMapping("/a")
public class Acontroller {
	
	@GetMapping()
	public String aform() {
		return ("a/form");
	}
	
	@PostMapping()
	public String aSubmit(@ModelAttribute("a") Acommand Acommand) {
		System.out.println(Acommand);
		return ("a/submit");
	}
}

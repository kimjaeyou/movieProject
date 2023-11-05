package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.ContentCommand;

@Controller
public class ValidatorController {
	
	@GetMapping("/valid/insertForm")
	public String form() {
			return "validator/createPage";
	}
	
	@RequestMapping("/valid/create")
	public String submit(@ModelAttribute("dto") @Validated ContentCommand command, BindingResult result) {
		String view ="validator/createDonePage";
		
		if(result.hasErrors()) {
			if(result.getFieldError("writer")!= null) {
				System.out.println("writer : "+result.getFieldError("writer").getDefaultMessage());
				System.out.println("content : "+result.getFieldError("content").getDefaultMessage());
			}
			view="validator/createPage";
		}
		return view;
	}
}

package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.OrderCommand;

@Controller
@RequestMapping("/orders/order") 
public class OrderController {

	@GetMapping
	public String form() {
		return "orders/orderForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("order") OrderCommand orderCommand) {
		return "orders/orderCompletion";
	}
}
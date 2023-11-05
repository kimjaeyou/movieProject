package com.example.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rest")
public class RestTestController {

	@GetMapping
	public String hello(Model m) {
		m.addAttribute("hello", "안녕,spring!");
		return "rest/form";
	}
	
	@PostMapping
	public String postsubmit(String name) {
		System.out.println("name:"+name);
		return "redirect:/";
	}
	
	
	@PutMapping
	public String putsubmit(String name) {
		System.out.println("name:"+name);
		return "redirect:/";
	}
	
	@DeleteMapping
	public String deletesubmit(String name) {
		System.out.println("name:"+name);
		return "redirect:/";
	}
}

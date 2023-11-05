package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public void hello(Model m) {
		m.addAttribute("hello", "안녕,spring!");
		//return "hello";
	}
	
	@GetMapping("/jsondata")
	@ResponseBody
	public String getJson() {
		List<String> list =new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("토마토");
		Gson gson =new Gson();
		return gson.toJson(list);
	}
}
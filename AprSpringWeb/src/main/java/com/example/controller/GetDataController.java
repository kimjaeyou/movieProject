package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class GetDataController {
	@RequestMapping("/jsondata2")
	public String getData() {
		List<String> list =new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("토마토");
		Gson gson =new Gson();
		return gson.toJson(list);
	}
}

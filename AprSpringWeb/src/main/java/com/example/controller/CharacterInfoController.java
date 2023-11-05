package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/character/{characterId}")
public class CharacterInfoController {
	@RequestMapping("/users/{id}")
	public String characterInfo(
				@PathVariable("id") String userId,
				@PathVariable int characterId, 
				ModelMap model) {
		model.addAttribute("userId", userId);
		model.addAttribute("characterId", characterId);
		return "character/users/info";
	}
}
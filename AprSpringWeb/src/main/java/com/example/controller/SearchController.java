package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
   
@Controller


public class SearchController {
	@RequestMapping("/search/internal")
	public ModelAndView searchInternal(
			String query,@RequestParam("p") int pageNumber) {
			System.out.println("query=" + query + ",pageNumber=" + pageNumber);
			return new ModelAndView("search/internal");
		}

		@RequestMapping("/search/external")
		public ModelAndView searchExternal(String query,
				@RequestParam(value = "p", defaultValue = "1") int pageNumber) {
			System.out.println("query=" + query + ",pageNumber=" + pageNumber);
			return new ModelAndView("search/external");
		}
}

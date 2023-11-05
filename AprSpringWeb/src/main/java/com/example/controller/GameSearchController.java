package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.commands.SearchCommand;
import com.example.service.SearchResult;   
import com.example.service.SearchService;



import com.example.commands.SearchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {
	
	@Autowired
	private SearchService searchService;

	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "뉴스"));
		options.add(new SearchType(3, "블로그"));
		return options;
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "게임", "웹툰", "IT" };
	}

	@RequestMapping("/search/main")
	public String main() {
		return "search/main";
	}

	@RequestMapping("/search/game")
	public String search(@ModelAttribute("command") SearchCommand command, Model m) {
		System.out.println("검색어 = " + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		m.addAttribute("searchResult",result);
		return "search/game";
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		//DB연동 select문 실행 select * from 테이블 where type=command.type & content =command.query
		this.searchService = searchService;
	}

}

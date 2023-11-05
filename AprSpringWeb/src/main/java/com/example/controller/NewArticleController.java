package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ArticleService;
import com.example.commands.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle")
public class NewArticleController {

	@Autowired
	private ArticleService articleService;

	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "article/newArticleForm";
		//요청처리 메서드에서 String 리턴시 리턴값 요청 경로
	}

	@PostMapping
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		System.out.println(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
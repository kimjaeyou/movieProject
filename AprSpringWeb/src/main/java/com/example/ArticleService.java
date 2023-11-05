package com.example;

import org.springframework.stereotype.Service;

import com.example.commands.NewArticleCommand;

@Service
public class ArticleService {
	public void writeArticle(NewArticleCommand command) {
		System.out.println("신규 게시글 등록: " + command);
	}    
}
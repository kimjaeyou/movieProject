package com.example.service;

import org.springframework.stereotype.Service;

import com.example.commands.SearchCommand;

@Service
public class SearchService {
	public SearchResult search(SearchCommand command) {
		return new SearchResult();
	}
}
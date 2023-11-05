package com.example.commands;

import lombok.Data;

@Data
public class SearchCommand {
	private String type;
	private String query;
	private int page;
}

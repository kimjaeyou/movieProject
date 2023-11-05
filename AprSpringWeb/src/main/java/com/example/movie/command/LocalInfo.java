package com.example.movie.command;

import java.util.List;

import lombok.Data;

@Data
public class LocalInfo {
	int total;
	List<Item> items;
}
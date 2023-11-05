package com.example.commands;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Acommand {
	private String name;
	private int age;
	@DateTimeFormat(pattern="yyyyMMdd")
	private String birth;
	private List<String> animals;
}

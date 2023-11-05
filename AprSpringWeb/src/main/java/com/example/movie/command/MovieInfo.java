package com.example.movie.command;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieInfo {
	String movieNm;
	List<Actors> actors;
}
package movieComm.DataStructure;

import lombok.Data;

@Data
public class MovieStructure {
	String title;
	String poster;
	String director;
	String genre;
	String movieSeq;

	public MovieStructure(String title, String poster, String director, String genre, String movieSeq) {
		this.title = title;
		this.poster = poster;
		this.director = director;
		this.genre = genre;
		this.movieSeq = movieSeq;
	}
}

package movieComm.apiconfig;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MovieListResult {
	int totCnt;
    String source;

    ArrayList<Movie> movieList = new ArrayList<Movie>();

}
package movieComm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.apiconfig.Director;
import movieComm.apiconfig.Movie;
import movieComm.apiconfig.Movie2;
import movieComm.apiconfig.MovieList;
import movieComm.apiconfig.MovieList2;
import movieComm.apiconfig.MoviiAPI;
import movieComm.kmdbApi.KMovieList;

@Service
public class BoxOffixeService {

	@Autowired
	MoviiAPI moviiAPI;

	public MovieList2 searchMovive() {

		MovieList2 dailly = moviiAPI.BestDailyMovies();
		ArrayList<String> nameList = new ArrayList<String>();
		MovieList list=null;
		
		String Mname;
		String AmovieCd;
		String BmovieCd;

		for (Movie2 i : dailly.boxOfficeResult.getDailyBoxOfficeList()) {
			Mname = i.getMovieNm();
			AmovieCd = i.getMovieCd();
			
			list =moviiAPI.SearchMoviesNM(Mname);
			
			/*
			 * System.out.println(AmovieCd); System.out.println(Mname);
			 * System.out.println(i);
			 * System.out.println(list.getMovieListResult().getMovieList());
			 */
			
			for (Movie j : list.getMovieListResult().getMovieList()) {
				BmovieCd = j.getMovieCd();
				if(AmovieCd.equals(BmovieCd)) {
					for(Director director : j.getDirectors()) {
						System.out.println(director.getPeopleNm());
						
						KMovieList movie = moviiAPI.KmdbMovies(Mname, director.getPeopleNm());
						System.out.println(movie);
					}//for kmdb search
				}//if
			}// movie all
		}//movie dailly

		return dailly;
	}

}

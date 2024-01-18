package movieComm.DataFormating;

import org.springframework.stereotype.Component;

import movieComm.DataStructure.DaillyStructure;
import movieComm.apiconfig.Movie2;
import movieComm.apiconfig.MovieList2;

@Component
public class DaillyFormat {
	
	public String reDailly(MovieList2 movie) {
		DaillyStructure addDayMovie;
		
		for (Movie2 i : movie.boxOfficeResult.getDailyBoxOfficeList()) {
			
			//addDayMovie = DaillyStructure new(i.getRank(),i.getRankOldAndNew(),i.getMovieNm(),i.getAudiAcc(),"");
		}
		
		return "aa";
	}
}

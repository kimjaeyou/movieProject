package movieComm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.DataStructure.MovieStructure;
import movieComm.apiconfig.Director2;
import movieComm.apiconfig.Movie2;
import movieComm.apiconfig.MovieList2;
import movieComm.apiconfig.MovieList3;
import movieComm.apiconfig.MoviiAPI;
import movieComm.kmdbApi.Datalist;
import movieComm.kmdbApi.Director;
import movieComm.kmdbApi.KMovieList;
import movieComm.kmdbApi.Movie;
import movieComm.text.StringTest;

@Service
public class BoxOffixeService {

	@Autowired
	MoviiAPI moviiAPI;

	public ArrayList<MovieStructure> searchMovive() {

		MovieList2 dailly = moviiAPI.BestDailyMovies();
		MovieList3 response;
		
		ArrayList<MovieStructure> movieData = new ArrayList<MovieStructure>();
		MovieStructure addMovieData;
		
		String Mname;
		String AmovieCd;
		boolean flag = false;
		int flagNum = 0;

		for (Movie2 i : dailly.boxOfficeResult.getDailyBoxOfficeList()) {
			Mname = i.getMovieNm();
			AmovieCd = i.getMovieCd();
			flag = false;//영화 순서 제어 플래그 다음 영화로 넘어가면 false로 초기화  
			
			response = moviiAPI.SearchMoviesCd(AmovieCd);
			KMovieList movie = moviiAPI.KmdbMovies(Mname);
			
			for (Director2 dir : response.getMovieInfoResult().getMovieInfo().getDirectors()) {
				
				//한 영화에 감독이 2명 이상일 수 있음 이때 필요한 경우는 1명을 통한 검색 이후 2번째는 불필요 이를 제어하기 위한 조건문 
				if (flag == true && flagNum >= 1) {
					flag = false;
					flagNum = 0;
					break;
				}
				
				
				for (Datalist m : movie.getData()) {
					for (Movie n : m.getResult()) {
						for (Director d : n.getDirectors().getDirector()) {
							
							//각 API가 저장하는 감독의 이름이 조금씩 다른 경우 존재 (EX- A:오네 B:호네) 이런 식의 상이함 해결을 위한 조건문 단어의 유사도를 분석하는 외부 라이브러리(Levenshtein) 사용해 같은 감독임을 판별
							if (StringTest.Levenshtein(d.getDirectorNm(), dir.getPeopleNm()) >= 0.6) { 

								// System.out.println("\n\n ");
								// System.out.println(n.getPlots().getPlot());
								//System.out.println("title : " + n.getTitle());
								//System.out.println("Poster : "+n.getPosters().split("\\|")[0]);
								//System.out.println("director : "+d.getDirectorNm());
								//System.out.println("genre : "+n.getGenre());
								//System.out.println("movieSeq : "+n.getMovieSeq());
								
								addMovieData= new MovieStructure(
														   	n.getTitle().replaceAll("!HS|!HE", ""), 
														   	n.getPosters().split("\\|")[0].replaceAll("!HS|!HE", ""), 
														   	d.getDirectorNm().replaceAll("!HS|!HE", ""),
														   	n.getGenre().replaceAll("!HS|!HE", ""),
														   	n.getMovieSeq().replaceAll("!HS|!HE", "")
														   );
								
								
								movieData.add(addMovieData);//새로운 영화 구조의 배열에 저장
								
								
								flag = true;//영화 감독을 찾으면 제어 Flag true로 초기화
								flagNum++; //찾은 개수 카운트 확인을 위한 제어 변수 ++
								
								break;
							}
						}
					}
				}
			}

		} // movie dailly
		//System.out.println(movieData);
		return movieData;
	}

}

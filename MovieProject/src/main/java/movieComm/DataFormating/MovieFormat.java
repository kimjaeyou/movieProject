package movieComm.DataFormating;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movieComm.DataStructure.DaillyStructure;
import movieComm.DataStructure.MovieStructure;
import movieComm.apiconfig.Director2;
import movieComm.apiconfig.Movie;
import movieComm.apiconfig.MovieList;
import movieComm.apiconfig.MovieList2;
import movieComm.apiconfig.MovieList3;
import movieComm.apiconfig.MoviiAPI;
import movieComm.kmdbApi.Datalist;
import movieComm.kmdbApi.Director;
import movieComm.kmdbApi.KMovieList;
import movieComm.text.StringTest;

@Component
public class MovieFormat {
	
	@Autowired
	MoviiAPI moviiAPI;

	public ArrayList<MovieStructure> reMovies() {

		String Mname; // 영화 이름
		String AmovieCd; // 영화 식별 코드
		boolean flag = false; // 순서 제어 플래그
		int flagNum = 0; // 순서 제어 변수

		MovieList list = moviiAPI.Movies(); // 일간 박스오피스
		MovieList3 response; // 영화 한편에 대한 조회

		ArrayList<MovieStructure> movieData = new ArrayList<MovieStructure>();
		MovieStructure addMovieData;

		for (Movie i : list.getMovieListResult().getMovieList()) {
			Mname = i.getMovieNm();
			AmovieCd = i.getMovieCd();
			flag = false;// 영화 순서 제어 플래그 다음 영화로 넘어가면 false로 초기화
			
			response = moviiAPI.SearchMoviesCd(AmovieCd);
			KMovieList movie = moviiAPI.KmdbMovies(Mname);
			
			for (Director2 dir : response.getMovieInfoResult().getMovieInfo().getDirectors()) {
				
				// 한 영화에 감독이 2명 이상일 수 있음 이때 필요한 경우는 1명을 통한 검색 이후 2번째는 불필요 이를 제어하기 위한 조건문
				if (flag == true && flagNum >= 1) {
					flag = false;
					flagNum = 0;
					break;
				}

				for (Datalist m : movie.getData()) {
					for (movieComm.kmdbApi.Movie n : m.getResult()) {
						
						for (Director d : n.getDirectors().getDirector()) {

							// 각 API가 저장하는 감독의 이름이 조금씩 다른 경우 존재 (EX- A:오네 B:호네) 이런 식의 상이함 해결을 위한 조건문 단어의
							// 유사도를 분석하는 외부 라이브러리(Levenshtein) 사용해 같은 감독임을 판별
							if (StringTest.Levenshtein(d.getDirectorNm(), dir.getPeopleNm()) >= 0.6 && !(n.getGenre().equals("에로")) && n.getPosters().split("\\|")[0] != "") {
								
								addMovieData = new MovieStructure(n.getTitle().replaceAll("!HS|!HE", ""),
										n.getPosters().split("\\|")[0].replaceAll("!HS|!HE", ""),
										d.getDirectorNm().replaceAll("!HS|!HE", ""),
										n.getGenre().replaceAll("!HS|!HE", ""),
										n.getMovieSeq().replaceAll("!HS|!HE", "")
										);

								movieData.add(addMovieData);// 새로운 영화 구조의 배열에 저장

								flag = true;// 영화 감독을 찾으면 제어 Flag true로 초기화
								flagNum++; // 찾은 개수 카운트 확인을 위한 제어 변수 ++

								break;
							}
						}
					}
				}
			}
		}

		return movieData;
	}
}

package movieComm.apiconfig;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import movieComm.kmdbApi.KMovieList;

@Component
public class MoviiAPI {

	@Autowired
	RestTemplate restTemplate;

	public MovieList Movies() {

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
				.queryParam("key", "2d73b2cbd2d56c40aaed49c613224130")
				.queryParam("itemPerPage", 100)
				.encode()
				.build()
				.toUri();

		MovieList list = restTemplate.getForObject(uri, MovieList.class);
		return list;
	}

	public MovieList2 BestDailyMovies() {
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = yesterday.format(formatter);
		

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
				.queryParam("key", "2d73b2cbd2d56c40aaed49c613224130")
				.queryParam("targetDt", formattedDate)
				.encode()
				.build()
				.toUri();

		MovieList2 list = restTemplate.getForObject(uri, MovieList2.class);
		return list;
	}
	
	public KMovieList KmdbMovies() {

		URI uri = UriComponentsBuilder.fromUriString("https://api.koreafilm.or.kr")
				.path("/openapi-data2/wisenut/search_api/search_json2.jsp")
				.queryParam("collection", "kmdb_new2")
				.queryParam("ServiceKey", "G7U7UP0992OID4W1ESGX")
				.encode()
				.build()
				.toUri();

		KMovieList list = restTemplate.getForObject(uri, KMovieList.class);
		System.out.println(list);
		return list;
	}
	
}

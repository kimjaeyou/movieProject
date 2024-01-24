package movieComm.apiconfig;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import movieComm.kmdbApi.KMovieList;

@Component
public class MoviiAPI {

	@Autowired
	RestTemplate restTemplate;

	public MovieList Movies() {

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
				.queryParam("key", "9551ed926c4a56d3a14a2ca1f1a33023")
				.queryParam("itemPerPage",100)
				.encode()
				.build()
				.toUri();

		MovieList list = restTemplate.getForObject(uri, MovieList.class);
		return list;
	}
	
	
	public MovieList SearchMoviesNM(String str) {

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
				.queryParam("key", "2d73b2cbd2d56c40aaed49c613224130")
				.queryParam("movieNm",str)
				.encode()
				.build()
				.toUri();

		MovieList list = restTemplate.getForObject(uri, MovieList.class);
		return list;
	}
	
	public MovieList SearchMoviesDNM(String str) {

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
				.queryParam("key", "2d73b2cbd2d56c40aaed49c613224130")
				.queryParam("directorNm",str)
				.encode()
				.build()
				.toUri();

		MovieList list = restTemplate.getForObject(uri, MovieList.class);
		return list;
	}
	
	
	public MovieList3 SearchMoviesCd(String str) {

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/movie/searchMovieInfo.json")
				.queryParam("key", "9551ed926c4a56d3a14a2ca1f1a33023")
				.queryParam("movieCd",str)
				.encode()
				.build()
				.toUri();

		MovieList3 list = restTemplate.getForObject(uri, MovieList3.class);
		return list;
	}
	
	

	public MovieList2 BestDailyMovies() {
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = yesterday.format(formatter);

		URI uri = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr")
				.path("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
				.queryParam("key", "9551ed926c4a56d3a14a2ca1f1a33023")
				.queryParam("targetDt", formattedDate)
				.encode()
				.build()
				.toUri();

		MovieList2 list = restTemplate.getForObject(uri, MovieList2.class);
		return list;
	}
	

	public KMovieList KmdbMovies(String str) {

		URI uri = UriComponentsBuilder.fromUriString("https://api.koreafilm.or.kr")
				.path("/openapi-data2/wisenut/search_api/search_json2.jsp")
				.queryParam("collection", "kmdb_new2")
				.queryParam("ServiceKey", "G7U7UP0992OID4W1ESGX")
				.queryParam("title", str)
				.queryParam("listCount", 100)
				.encode()
				.build()
				.toUri();

		RestTemplate restTemplate = new RestTemplate();
		String list = restTemplate.getForObject(uri, String.class);
		list = list.trim();

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			KMovieList kmovieList = objectMapper.readValue(list, KMovieList.class);
			return kmovieList;
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	public KMovieList KmdbMoviesSeq(String str) {

		URI uri = UriComponentsBuilder.fromUriString("https://api.koreafilm.or.kr")
				.path("/openapi-data2/wisenut/search_api/search_json2.jsp")
				.queryParam("collection", "kmdb_new2")
				.queryParam("ServiceKey", "G7U7UP0992OID4W1ESGX")
				.queryParam("movieSeq", str)
				.queryParam("listCount", 100)
				.encode()
				.build()
				.toUri();

		RestTemplate restTemplate = new RestTemplate();
		String list = restTemplate.getForObject(uri, String.class);
		list = list.trim();

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			KMovieList kmovieList = objectMapper.readValue(list, KMovieList.class);
			return kmovieList;
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public KMovieList AllKmdbMovies() {

		URI uri = UriComponentsBuilder.fromUriString("https://api.koreafilm.or.kr")
				.path("/openapi-data2/wisenut/search_api/search_json2.jsp")
				.queryParam("collection", "kmdb_new2")
				.queryParam("ServiceKey", "G7U7UP0992OID4W1ESGX")
				.encode()
				.build()
				.toUri();

		RestTemplate restTemplate = new RestTemplate();
		String list = restTemplate.getForObject(uri, String.class);
		list = list.trim();

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			KMovieList kmovieList = objectMapper.readValue(list, KMovieList.class);
			return kmovieList;
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

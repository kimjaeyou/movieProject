package movieComm.apiconfig;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MoviiAPI {
	
	@Autowired
	RestTemplate restTemplate;

    public MovieList searchMovies(){
    	
    	URI uri = UriComponentsBuilder
	            .fromUriString("http://www.kobis.or.kr")
	            .path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
	            .queryParam("key","2d73b2cbd2d56c40aaed49c613224130")
	            .queryParam("itemPerPage",30)
	            .encode()
	            .build()
	            .toUri();
    	
    	MovieList list =restTemplate.getForObject(uri, MovieList.class);
        return list;
    }
}

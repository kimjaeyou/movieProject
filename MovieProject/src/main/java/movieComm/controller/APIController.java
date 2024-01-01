package movieComm.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import movieComm.dto.Movie_listDto;


@Controller 
public class APIController {
	@Autowired
	RestTemplate restTemplate;
	
	

	@RequestMapping("/boxOffice/oneday")
	public String getMovie(Model model) {

		Date curDate =  new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String strDate = format.format(curDate);
		
		
		
		URI uri = UriComponentsBuilder
	            .fromUriString("http://www.kobis.or.kr")
	            .path("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
	            .queryParam("key","f5eef3421c602c6cb7ea224104795888")
	            .queryParam("targetDt",strDate)
	            .encode()
	            .build()
	            .toUri();

		Movie_listDto list = restTemplate.getForObject(uri, Movie_listDto.class);
		model.addAttribute("boxOfficeList", list);
		System.out.println("this is :"+list);
		return "movie/boxOffice";
	}
	
	

}

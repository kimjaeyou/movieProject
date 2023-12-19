package movieComm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import movieComm.dao.Movie_listDao;
import movieComm.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	Movie_listDao mDao;
	
	
	@Autowired
	MainService Moservice;
	
	@RequestMapping({"home","/"})
	public String goMain(Model m) {
		List<Map<String, String>> mlist = Moservice.reMainList();
		m.addAttribute("mlist",mlist);
		return "home";
	}
	
	@GetMapping("MyPage")
	public String goMyPage() {
		return "Mypage/Info";
	}
	
	
	@RequestMapping("MovieInfo")
	public static String MovieInfo() {
		return "Movie/Info";
	}
	
	@RequestMapping("Ticketing")
	public static String Ticketing() {
		return "Ticketing/Info";
	}
	@RequestMapping("movieReview")
	public static String Review() {
		return "Movie/movieReview";
	}
	@RequestMapping("reviewList")
	public static String reviewList() {
		return "Movie/reviewList";
	}
	@RequestMapping("reviewBoard")
	public static String reviewBoard() {
		return "Movie/reviewBoard";
	}
	@RequestMapping("movieHistory")
	public static String movieHistory() {
		return "Movie/movieHistory";
	}

}

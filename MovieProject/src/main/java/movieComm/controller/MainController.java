package movieComm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import movieComm.dao.Movie_listDao;
import movieComm.dto.UserDto;
import movieComm.service.MainService;
import movieComm.service.MypageService;

@Controller
public class MainController {
	
	@Autowired
	Movie_listDao mDao;
	
	@Autowired
	MainService Moservice;
	
	@Autowired
	MypageService MpService;
	
	@RequestMapping({"home","/"})
	public String goMain(Model m,HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		List<Map<String, String>> mlist = Moservice.reMainList();
		m.addAttribute("userid",userid);
		m.addAttribute("mlist",mlist);
		return "home";
	}
	
	@GetMapping("MyPage")
	public String goMyPage(Model m,HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		UserDto user = MpService.userInfo(userid);
		m.addAttribute("userid",userid);
		m.addAttribute("user",user);
		System.out.println(user);
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

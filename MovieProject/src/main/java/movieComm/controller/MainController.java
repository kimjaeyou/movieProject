package movieComm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import movieComm.dao.Movie_listDao;
import movieComm.dto.ReviewDto;
import movieComm.dto.UserDto;
import movieComm.service.MainService;
import movieComm.service.MypageService;
import movieComm.service.ReviewService;

@Controller
public class MainController {
	
	@Autowired
	Movie_listDao mDao;
	
	@Autowired
	MainService Moservice;
	
	@Autowired
	MypageService MpService;
	
	@Autowired
	ReviewService Reservice;
	
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
	public String movieHistory(Model m, HttpSession session) {
		List<Map<String, String>> tlist = Reservice.title();
		String userid = (String) session.getAttribute("userid");
		m.addAttribute("userid",userid);
		m.addAttribute("tlist",tlist);
		return "Movie/movieHistory";
	}
	
	@RequestMapping("reviewScript")
	public static String reviewScript(Model m,HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		m.addAttribute("user_id",userid);
		System.out.println(userid);
		return "Movie/reviewScript";
	}
	
	@PostMapping("reviewList")
	public String reviewList(ReviewDto review) {
		System.out.println(review);
		Reservice.script(review);
		return "Movie/reviewList";
	}
}

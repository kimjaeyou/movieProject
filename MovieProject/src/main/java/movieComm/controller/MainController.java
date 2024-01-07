package movieComm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import movieComm.apiconfig.MovieList;
import movieComm.apiconfig.MovieList2;
import movieComm.apiconfig.MoviiAPI;
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

	@Autowired
	MoviiAPI moviiAPI;
	

	@RequestMapping({ "home", "/" })
	public String goMain(Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<Map<String, String>> mlist = Moservice.reMainList();
		m.addAttribute("userid", userid);
		m.addAttribute("mlist", mlist);
		MovieList list =moviiAPI.Movies();
		m.addAttribute("list", list);
		System.out.println(list);
		MovieList2 list2 =moviiAPI.BestDailyMovies();
		m.addAttribute("list2", list2);
		System.out.println(list2);
		return "home";
	}

	@GetMapping("MyPage")
	public String goMyPage(Model m, HttpSession session) throws Exception{
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		UserDto user = MpService.userInfo(userid);
		m.addAttribute("userid", userid);
		m.addAttribute("user", user);
		System.out.println(user);
		
		return "Mypage/Info";
	
	}
 
	@RequestMapping("MovieInfo")
	public static String MovieInfo() {
		return "Movie/Info";
	}

}

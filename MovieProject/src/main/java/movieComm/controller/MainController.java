package movieComm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import movieComm.DataFormating.DaillyFormat;
import movieComm.DataFormating.MovieFormat;
import movieComm.DataStructure.DaillyStructure;
import movieComm.DataStructure.MovieStructure;
import movieComm.apiconfig.MovieList;
import movieComm.apiconfig.MovieList2;
import movieComm.apiconfig.MoviiAPI;
import movieComm.dao.Movie_listDao;
import movieComm.dto.UserDto;
import movieComm.kmdbApi.KMovieList;
import movieComm.service.BoxOffixeService;
import movieComm.service.MainService;
import movieComm.service.MovieService;
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
	
	@Autowired
	BoxOffixeService boxService;
	
	@Autowired
	DaillyFormat dayFormat;
	
	@Autowired
	MovieFormat movieFormat;
	
	@Autowired
	MovieService movieService;

	@RequestMapping({ "home", "/" })
	public String goMain(Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		m.addAttribute("userid", userid);

		ArrayList<MovieStructure> list = movieService.movieDataGet();//movieFormat.reMovies();// 포맷팅 데이터
		m.addAttribute("list", list);
		
		ArrayList<DaillyStructure> list2 = movieService.daillyDataGet();//dayFormat.reDailly();//오늘의 박스오피스 포맷팅 데이터
		m.addAttribute("list2", list2);
		
		//movieService.movieDataInsert(); //-영화 집어 넣는 코드
		//movieService.daillyDataInsert(); //-박스오피스
		return "home";
	}
	
	@RequestMapping("MovieInfo")
	public String MovieInfo(Model model) throws Exception{
		
		ArrayList<MovieStructure> listArr = boxService.searchMovive();
		
		model.addAttribute("list", listArr);
		return "Movie/boxOffice";
	}

	@GetMapping("MyPage")
	public String goMyPage(Model m, HttpSession session) throws Exception{
		String userid = (String) session.getAttribute("userid");
		UserDto user = MpService.userInfo(userid);
		m.addAttribute("userid", userid);
		m.addAttribute("user", user);
		
		return "Mypage/Info";
	
	}

}

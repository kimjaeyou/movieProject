package movieComm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import movieComm.dao.ReviewDao;
import movieComm.dao.movieContentDao;
import movieComm.dto.ReviewDto;
import movieComm.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	movieContentDao mCDao;
	
	@Autowired
	ReviewDao rDao;
	
	@Autowired
	ReviewService Reservice;
	
	@RequestMapping("movieReview")
	public String Review(@RequestParam String movieCd, @RequestParam String movieNm,@RequestParam String prdYear,@RequestParam String typeNm, Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<Map<String, String>> getReview = Reservice.getReview(movieCd);
		m.addAttribute("getReview", getReview);
		m.addAttribute("userid",userid);
		m.addAttribute("movieCd", movieCd);
		m.addAttribute("movieNm", movieNm);
		m.addAttribute("prdYear", prdYear);
		m.addAttribute("typeNm", typeNm);
		return "Movie/movieReview";
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
	public static String reviewScript(@RequestParam String movieCd, @RequestParam String movieNm, Model m,HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		m.addAttribute("movieCd", movieCd);
		m.addAttribute("movieNm", movieNm);
		m.addAttribute("user_id",userid);
		System.out.println(movieNm);
		return "Movie/reviewScript";
	}
	
	@PostMapping("reviewList")
	public String reviewList(Model m, ReviewDto review, RedirectAttributes redirectAttributes) {
	    // 리뷰를 저장하는 메서드 호출
	    Reservice.script(review);
	    
	    // POST 요청 후에 리다이렉션을 통해 GET 요청으로 변경
	    return "redirect:/reviewList";
	}

	@GetMapping("reviewList")
	public String getReviewList(Model m) {
	    // 리뷰 목록을 다시 불러와서 모델에 추가
	    List<Map<String, String>> reviewScript = Reservice.getReviewScript();
	    m.addAttribute("reviewScript", reviewScript);
	    
	    return "Movie/reviewList";
	}
	@RequestMapping("reviewPoint_1")
	public String reviewPoint_1(Model m) {
		List<Map<String,String>> point_1 = Reservice.point_1();
		m.addAttribute("point_1", point_1);
		return "Movie/reviewPoint_1";
	}
	@RequestMapping("reviewPoint_2")
	public String reviewPoint_2(Model m) {
		List<Map<String,String>> point_2 = Reservice.point_2();
		m.addAttribute("point_2", point_2);
		return "Movie/reviewPoint_2";
	}
	@RequestMapping("reviewPoint_3")
	public String reviewPoint_3(Model m) {
		List<Map<String,String>> point_3 = Reservice.point_3();
		m.addAttribute("point_3", point_3);
		return "Movie/reviewPoint_3";
	}
	@RequestMapping("reviewPoint_4")
	public String reviewPoint_4(Model m) {
		List<Map<String,String>> point_4 = Reservice.point_4();
		m.addAttribute("point_4", point_4);
		return "Movie/reviewPoint_4";
	}
	@RequestMapping("reviewPoint_5")
	public String reviewPoint_5(Model m) {
		List<Map<String,String>> point_5 = Reservice.point_5();
		m.addAttribute("point_5", point_5);
		return "Movie/reviewPoint_5";
	}
}

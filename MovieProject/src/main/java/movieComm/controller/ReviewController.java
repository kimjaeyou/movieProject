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
import movieComm.apiconfig.MoviiAPI;
import movieComm.dao.ReviewDao;
import movieComm.dao.movieContentDao;
import movieComm.dto.ReviewDto;
import movieComm.kmdbApi.Datalist;
import movieComm.kmdbApi.KMovieList;
import movieComm.kmdbApi.Movie;
import movieComm.kmdbApi.Plot;
import movieComm.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	movieContentDao mCDao;

	@Autowired
	ReviewDao rDao;

	@Autowired
	ReviewService Reservice;

	@Autowired
	MoviiAPI moApi;

	@RequestMapping("movieReview")
	public String Review(String movieCd, String title, Model m, HttpSession session) {
		String poster = null;
		String movieTitle = null;
		String str = null;
<<<<<<< HEAD
=======
		
>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git

		String userid = (String) session.getAttribute("userid");
		List<Map<String, String>> getReview = Reservice.getReview(movieCd);
		m.addAttribute("getReview", getReview);
		m.addAttribute("userid", userid);
		KMovieList list = moApi.KmdbMoviesSeq(movieCd);
		for (Datalist m1 : list.getData()) {
			for (Movie n : m1.getResult()) {
<<<<<<< HEAD
				poster = n.getPosters().split("\\|")[0];
				movieTitle = n.getTitle();
				for (Plot p : n.getPlots().getPlot())
					str = p.getPlotText();
=======
				if (n.getTitle().replaceAll(" ","").equals(title.replaceAll(" ",""))) {
					poster = n.getPosters().split("\\|")[0];
					movieTitle = n.getTitle();
					for (Plot p : n.getPlots().getPlot())
						str = p.getPlotText();
				}
>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git
			}
		}

		m.addAttribute("movieTitle", movieTitle);
		m.addAttribute("list", list);
		m.addAttribute("movieCd", movieCd);
		m.addAttribute("post", poster);
		m.addAttribute("str", str);
		
		double score =0;
		
		score = Reservice.getAvgScore(movieTitle,movieCd);
		m.addAttribute("score", score);
		
		return "Movie/movieReview";
	}

	@RequestMapping("reviewBoard")
	public static String reviewBoard() {
		return "Movie/reviewBoard";
	}

	@RequestMapping("movieHistory")
	public String movieHistory(Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<Map<String, String>> getUserId = Reservice.getUserId(userid);
		m.addAttribute("getUserId", getUserId);
		return "Movie/movieHistory";
	}
	@PostMapping("movieHistory")
	public String deleteReview(@RequestParam("review_id") int review_id, Model m, ReviewDto review, RedirectAttributes redirectAttributes) {
	    // 리뷰를 삭제하는 메서드 호출
	    Reservice.delete_review(review_id);
	    // POST 요청 후에 리다이렉션을 통해 GET 요청으로 변경
	    return "redirect:/movieHistory";
	}
	@RequestMapping("reviewScript")
	public static String reviewScript(@RequestParam String movieCd, @RequestParam String movieNm,
			@RequestParam String post, @RequestParam String movieTitle, Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git
		m.addAttribute("movieTitle", movieTitle);
		m.addAttribute("post", post);
		m.addAttribute("movieCd", movieCd);
		m.addAttribute("movieNm", movieNm);
		m.addAttribute("user_id", userid);
		return "Movie/reviewScript";
	}

	@PostMapping("reviewList")
	public String reviewList(Model m, ReviewDto review, RedirectAttributes redirectAttributes) {
		// 리뷰를 저장하는 메서드 호출
<<<<<<< HEAD
=======
		System.out.println(review + "여기");
>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git
		Reservice.script(review);
		// POST 요청 후에 리다이렉션을 통해 GET 요청으로 변경
		return "redirect:/reviewList";
	}

	@GetMapping("reviewList")
	public String getReviewList(String review_id, Model m) {
		// 리뷰 목록을 다시 불러와서 모델에 추가
		List<Map<String, String>> reviewScript = Reservice.getReviewScript();
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git
		m.addAttribute("reviewScript", reviewScript);
		return "Movie/reviewList";
	}

	@RequestMapping("reviewPoint_1")
	public String reviewPoint_1(Model m) {
		List<Map<String, String>> point_1 = Reservice.point_1();
		m.addAttribute("point_1", point_1);
		return "Movie/reviewPoint_1";
	}

	@RequestMapping("searchMovieTitle")
	public String searchMovieTitle(@RequestParam(name = "stx", required = false) String searchTerm, Model m) {
		List<Map<String, String>> getmovieTitle = Reservice.getmovieTitle(searchTerm);
		m.addAttribute("getmovieTitle", getmovieTitle);
		return "Movie/searchMovieTitle";
	}

	@RequestMapping("reviewPoint_2")
	public String reviewPoint_2(Model m) {
		List<Map<String, String>> point_2 = Reservice.point_2();
		m.addAttribute("point_2", point_2);
		return "Movie/reviewPoint_2";
	}

	@RequestMapping("reviewPoint_3")
	public String reviewPoint_3(Model m) {
		List<Map<String, String>> point_3 = Reservice.point_3();
		m.addAttribute("point_3", point_3);
		return "Movie/reviewPoint_3";
	}

	@RequestMapping("reviewPoint_4")
	public String reviewPoint_4(Model m) {
		List<Map<String, String>> point_4 = Reservice.point_4();
		m.addAttribute("point_4", point_4);
		return "Movie/reviewPoint_4";
	}

	@RequestMapping("reviewPoint_5")
	public String reviewPoint_5(Model m) {
		List<Map<String, String>> point_5 = Reservice.point_5();
		m.addAttribute("point_5", point_5);
		return "Movie/reviewPoint_5";
	}
	@GetMapping("contentModify")
	public String contentModify(@RequestParam String content, @RequestParam int score, @RequestParam String review_id, Model m, HttpSession session) {
		//Reservice.update_review(content, score, review_id);
		return "Movie/contentModify";
	}
	@PostMapping("contentModify")
	public String contentModify_post(@RequestParam String content, @RequestParam int score, @RequestParam String review_id, Model m, HttpSession session) {
		Reservice.update_review(content, score, review_id);
		List<Map<String, String>> reviewScript = Reservice.getReviewScript();
		
		m.addAttribute("reviewScript", reviewScript);
		return "Movie/reviewList";
	}
	
}

package movieComm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.dao.ReviewDao;
import movieComm.dao.movieContentDao;
import movieComm.dto.ReviewDto;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDao Rdao;
	
	@Autowired
	movieContentDao mCdao;
	
	public List<Map<String, String>> W_history() {
		List<Map<String, String>> mlist = Rdao.getList();
		return mlist;
	}
	public List<Map<String, String>> title() {
		List<Map<String, String>> tlist = mCdao.getList();
		return tlist;
	}
	public void script(ReviewDto review) {
		Rdao.review(review);
	}
	public List<Map<String, String>> getReviewScript() {
		List<Map<String, String>> reviewScript = Rdao.getList();
		return reviewScript;
	}
	public List<Map<String, String>> getReview(String movieCd) {
		List<Map<String, String>> getReview = Rdao.getReview(movieCd);
		return getReview;
	}
	public List<Map<String, String>> point_1() {
		List<Map<String, String>> mlist = Rdao.getP_1();
		return mlist;
	}
	public List<Map<String, String>> point_2() {
		List<Map<String, String>> mlist = Rdao.getP_2();
		return mlist;
	}
	public List<Map<String, String>> point_3() {
		List<Map<String, String>> mlist = Rdao.getP_3();
		return mlist;
	}
	public List<Map<String, String>> point_4() {
		List<Map<String, String>> mlist = Rdao.getP_4();
		return mlist;
	}
	public List<Map<String, String>> point_5() {
		List<Map<String, String>> mlist = Rdao.getP_5();
		return mlist;
	}
	public List<Map<String, String>> getmovieTitle(String a){
		List<Map<String, String>> movieTitles = Rdao.getmovieTitle(a);
		return movieTitles;
	}
<<<<<<< HEAD
	public List<Map<String, String>> getUserId(String a){
		List<Map<String, String>> getUserId = Rdao.getUserId(a);
		return getUserId;
	}
	public void update_review(String content, int score, String review_id){
		Rdao.update_review(content, score, review_id);
	}
	public void delete_review(int review_id) {
		Rdao.delete_review(review_id);
=======
	
	public double getAvgScore(String movieTitle, String movieCd){
		
		double sum = 0;
		double total=0;
		List<Integer>ScoreArr = Rdao.getScore(movieTitle, movieCd);
		System.out.println(movieTitle);
		for(int score : ScoreArr) {
			sum += score;
		}
		if(sum != 0) {
			total=sum/ScoreArr.size();
		}
		
		return total;
>>>>>>> branch 'main' of https://github.com/kimjaeyou/movieProject.git
	}
}

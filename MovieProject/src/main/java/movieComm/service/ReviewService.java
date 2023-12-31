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
}

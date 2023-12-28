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
		System.out.println(""+mlist);
		return mlist;
	}
	public List<Map<String, String>> title() {
		List<Map<String, String>> tlist = mCdao.getList();
		System.out.println(""+tlist);
		return tlist;
	}
	
	public void script(ReviewDto review) {
		Rdao.review(review);
	}
}

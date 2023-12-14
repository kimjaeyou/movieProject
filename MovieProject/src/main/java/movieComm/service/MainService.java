package movieComm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.dao.Movie_listDao;

@Service
public class MainService {
	
	@Autowired
	Movie_listDao mDao;
	
	public List<Map<String, String>> reMainList() {
		List<Map<String, String>> mlist = mDao.getList();
		System.out.println("               check:anchor_movie"+mlist);
		return mlist;
	}
}

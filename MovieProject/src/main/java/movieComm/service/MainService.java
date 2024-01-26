package movieComm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.DataStructure.MovieStructure;
import movieComm.dao.MovieDao;
import movieComm.dao.Movie_listDao;

@Service
public class MainService {
	
	@Autowired
	Movie_listDao mDao;
	
	@Autowired
	MovieDao movieDao;
	
	
	public List<Map<String, String>> reMainList() {
		List<Map<String, String>> mlist = mDao.getList();
		return mlist;
	}
	
	public ArrayList<MovieStructure> searchServ(String str){
		System.out.println(str+"서비스단임");
		
		ArrayList<MovieStructure>searchList = movieDao.GetSearchs(str);
		
		System.out.println(searchList);
		return searchList;
	}
}

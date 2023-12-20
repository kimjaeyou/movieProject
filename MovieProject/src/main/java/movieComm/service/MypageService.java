package movieComm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.dao.UserDao;
import movieComm.dto.UserDto;

@Service
public class MypageService {
	
	@Autowired
	UserDao uDao;
	
	public UserDto userInfo(String userid) {
		UserDto user = uDao.findById(userid);
		return user;
	}
}

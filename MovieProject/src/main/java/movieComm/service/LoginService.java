package movieComm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import movieComm.dao.UserDao;

@Service
public class LoginService {
	@Autowired
	UserDao dao;
	
	public int checkId(String user_id) {
		return dao.IdCheck(user_id);
	}
	
}

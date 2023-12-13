package movieComm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import movieComm.dao.UserDao;
import movieComm.dto.UserDto;


@Service
public class LoginService {
	@Autowired
	UserDao dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public int checkId(String user_id) {
		System.out.println("check:"+user_id);
		return dao.IdCheck(user_id);
	}
	
	public int insertUser(UserDto user) {
		System.out.println("anchor1");
		//암호화(BCrypt 알고리즘 )
		user.setUser_pw(encoder.encode(user.getUser_pw()));	
		System.out.println("anchor2");
		System.out.println(user);
		int i = dao.insertUser(user);
		System.out.println(i);
		
		return i;
	}
}

package movieComm.loginConfig;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import movieComm.dto.UserDto;



public class LoginUser extends User{
private static final long serialVersionUID = 1L;
	
	private UserDto user;
	
	public LoginUser(UserDto user) {
	    //super(user.getUserid(), "{noop}"+user.getUserpw(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		super(user.getUser_id(), user.getUser_pw(), AuthorityUtils.createAuthorityList());
		this.user = user;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UserDto getUser() {
		return user;
	}
}

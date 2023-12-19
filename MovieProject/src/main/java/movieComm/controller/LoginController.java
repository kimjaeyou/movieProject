package movieComm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import movieComm.dto.UserDto;
import movieComm.service.LoginService;



@Controller
public class LoginController {
	
	@Autowired
	LoginService service;

	@GetMapping("login")
	public static String login() {
		return "Login/login";
	}
	
	@RequestMapping("login/insert")
	public static String loginInsert() {
		System.out.println("here1");
		return "Login/insert";
	}
	
	@PostMapping("login/insert")
	public String insert(UserDto user) {
		System.out.println("here2");
		System.out.println(user);
		service.insertUser(user);
		return "redirect:/login";
	}
	
	
	@GetMapping("/login/idcheck")
	@ResponseBody  // JSON 형식으로 응답을 반환
	public Map<String, Integer> idcheck(String user_id) {
		System.out.println("anchor_idcheck1");
		System.out.println(user_id);
	    int cid = service.checkId(user_id);
	    Map<String, Integer> response = new HashMap<>();
	    System.out.println(cid);
	    response.put("cid", cid);
	    return response;
	}
}

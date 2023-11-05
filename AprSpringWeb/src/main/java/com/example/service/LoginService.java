package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;


@Service
public class LoginService {

	@Autowired
	LoginDao dao;
	
	public String login(String id) {
		return dao.login(id);
	}
	
}
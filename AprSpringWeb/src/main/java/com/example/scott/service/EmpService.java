package com.example.scott.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scott.dto.Dept;
import com.example.scott.dto.Emp;
import com.example.scott.dao.EmpDao;

@Service
public class EmpService {
	
	@Autowired
	EmpDao dao;
	
	public List<Map<String,Object>> selectDept(){
		return dao.selectDept();
	}
	
	public List<Map<String,Object>> empSearch(int deptno){
		return dao.empSearch(deptno);
	}

	public Emp emp(int empno) {
		return dao.emp(empno);
	}

	public List<Map<String, Object>> enames(String ename) {
		return dao.enames(ename);
	}
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DeptDao;
import com.example.dto.Dept;

@Service
public class DeptService {
	
	@Autowired
	DeptDao dao;
	
	  
	public List<Dept> deptAll(){
		return dao.deptAll();
	}
	////////////-추가
	public int nwDeptno(){
		return dao.nwDeptno();
	}
	
	@Transactional
	public int addDept(Dept dept){
		//dao.addDept(dept);
		//dao.addDept(dept);
		return dao.addDept(dept);
	}
	
	public int updateDept(Dept dept){
		return dao.updateDept(dept);
	}
	
	public void deleteDept(int deptno){
		 dao.deleteDept(deptno);
	}
	public List<Dept> searchDept(String dname) {
		return dao.searchDept(dname);
	}
	
	/*
	 * public List<Dept> deptnoSearch(){ return dao.deptnoSearch(int deptno); }
	 */
	
}
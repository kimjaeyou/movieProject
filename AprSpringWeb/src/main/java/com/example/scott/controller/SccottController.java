package com.example.scott.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scott.dto.Dept;
import com.example.scott.dto.Emp;
import com.example.scott.service.EmpService;
import com.google.gson.Gson;

@Controller
public class SccottController {
	
	@Autowired
	EmpService eservice;
	
	@GetMapping("/selectDept")
	public String searchDept(Model m) {
		List<Map<String,Object>> elist = eservice.selectDept();
		m.addAttribute("selectEmp",elist);

		return "scott/emp";
	}
	
	
	@GetMapping("/emps/{deptno}")
	@ResponseBody//view없이 바로 보냄
	public String empSearch(Model m, @PathVariable int deptno) {
		List<Map<String,Object>> emps=eservice.empSearch(deptno);
		Gson gson = new Gson();
		String elist=gson.toJson(emps);		
		return elist;
	}
	
	
	@GetMapping("/emp/{empno}")
	@ResponseBody//view없이 바로 보냄
	public String emp(@PathVariable int empno) {
		Emp emp=eservice.emp(empno);
		Gson gson = new Gson();
		String e=gson.toJson(emp);		
		return e;
	}
	
	
	@GetMapping("/searchname")
	public String searchform() {
		return "scott/nameform";
	}
	
	
	@PostMapping("/searchname")
	public String search(String ename,Model model){
		model.addAttribute("ename",ename);
		List<Map<String,Object>> elist = eservice.enames(ename);
		System.out.println(elist);
		if(elist.size()==0) {
			model.addAttribute("ename","0"); 
		}
		else {model.addAttribute("ename",elist);}
		return "scott/names";
	}
	
}

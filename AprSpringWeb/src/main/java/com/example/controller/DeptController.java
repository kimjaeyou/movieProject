package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.Dept;
import com.example.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService dservice;
	
	@GetMapping("/deptAll")
	public String deptAll(Model m) {
		List<Dept> dlist = dservice.deptAll();
		m.addAttribute("deptAll",dlist);

		return "dept/deptAll";
	}	
	
	@GetMapping("/add")
	public String form(Model model) {
		int nwDeptno =dservice.nwDeptno();
		model.addAttribute("nw",nwDeptno);
		return "dept/form";
	}
	
	
	@PostMapping("/add")
	public String add(Dept dept,Model model){
		int sucNo = dservice.addDept(dept);
		if(sucNo==0) {
			model.addAttribute("msg","can't insert");
		}
		else {model.addAttribute("sn",sucNo);}
		return "dept/addresult";
	}
	
	@GetMapping("/update/{deptno}")//restful처리
	public String updateform(@PathVariable int deptno,Model m) {//restful처리
		m.addAttribute("deptno",deptno);
		
		return "dept/updateform";
	}
	
	@PutMapping("/update")
	public String update(Dept dept,Model model) {
		dservice.updateDept(dept);
		return "redirect:/";
	}
	
	
	@RequestMapping("/delete/{deptno}")//restful처리
	public String delete(@PathVariable int deptno) {//restful처리
		dservice.deleteDept(deptno);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/search")
	public String searchform() {
		return "dept/searchform";
	}
	
	
	@PostMapping("/search")
	public String search(String dname,Model model){
		model.addAttribute("dname",dname);
		List<Dept> dlist = dservice.searchDept(dname);
		if(dlist.size()==0) {
			model.addAttribute("msg","no match search");
		}
		else {model.addAttribute("deptAll",dlist);}
		return "dept/searchresult";
	}
	
	
		
}
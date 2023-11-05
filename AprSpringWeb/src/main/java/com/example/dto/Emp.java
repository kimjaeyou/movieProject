package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job; 
	private int MGR;
	private Date johiredate;
	private int sal;
	private int comm;
	private int deptno;
}

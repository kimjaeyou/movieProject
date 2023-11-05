package com.example.scott.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.scott.dto.Dept;
import com.example.scott.dto.Emp;


@Mapper
public interface EmpDao {
	
	@Select("select dname,deptno from dept")
	public List<Map<String,Object>> selectDept();
	
	@Select("select empno, ename from emp where deptno= #{deptno}")
	public List<Map<String,Object>> empSearch(int deptno);
	
	@Select("select * from emp where empno= #{empno}")
	public Emp emp(int empno);
	
	@Select("select ename,empno, dname from emp inner join dept using(deptno) where ename like concat('%', #{ename}, '%')")
	public List<Map<String,Object>> enames(String ename);
	
	
	
}

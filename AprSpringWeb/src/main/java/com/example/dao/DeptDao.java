package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Dept;

@Mapper
public interface DeptDao {
	@Select("select * from dept order by deptno")
	public List<Dept> deptAll();
	
	@Insert("insert into dept(deptno, dname,loc) values(#{deptno},#{dname},#{loc})")
	public int addDept(Dept dept);
	
	@Select("select max(deptno)+10 as max from dept")
	public int nwDeptno();
	
	public int updateDept(Dept dept);
	
	@Delete("delete from dept where deptno=#{deptno}")
	public int deleteDept(int deptno);
	
	@Select("select * from dept where dname like concat('%', #{dname}, '%')")
	public List<Dept> searchDept(String dname);
	
}
//dao==Mapper 연결 name똑같이

//dto=#{변수명}
//map=#{key}

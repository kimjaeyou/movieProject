package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FileinfoDao;
import com.example.dto.FileinfoDto;



@Service
public class FileinfoService {
	
	@Autowired
	FileinfoDao dao;
	
	public int insertFile(FileinfoDto file) {
		return dao.insertFile(file);
	}
	
	public List<FileinfoDto>  fileList(){
		return dao.fileList();
	}
	
	public FileinfoDto fileOne(int fileid) {
		return dao.fileOne(fileid);
	}
	
	
	public int deleteFile(FileinfoDto file) {
		return dao.deleteFile(file);
	}
}
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.dto.FileinfoDto;

@Mapper

public interface FileinfoDao {
	
	@Insert(value="insert into fileinfo(name, path, filesize, description) values(#{name}, #{path}, #{filesize},#{description})")
	@Options(useGeneratedKeys = true, keyProperty = "fileid")
	int insertFile(FileinfoDto file);
	
	@Select("select * from fileinfo")
	List<FileinfoDto>  fileList();
	
	@Select("select * from fileinfo where fileid = #{fileid}")
	FileinfoDto fileOne(int fileid);
	
	@Delete("delete from fileinfo where fileid= #{fileid}")
	int deleteFile(FileinfoDto file);
}

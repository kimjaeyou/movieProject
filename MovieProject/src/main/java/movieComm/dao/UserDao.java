package movieComm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import movieComm.dto.UserDto;


@Mapper
public interface UserDao {
	@Select("select count(*) from user where user_id = #{user_id}")
	int IdCheck(String user_id);
	
	@Select("select * from user where user_id = #{user_id}")
	UserDto findById(String user_id);
}

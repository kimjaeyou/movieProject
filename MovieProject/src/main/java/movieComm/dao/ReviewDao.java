package movieComm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import movieComm.dto.ReviewDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {
	
	@Select("select * from review")
	List<Map<String, String>>getList();
	
	@Insert("insert into review (score, content, user_id, movieCd) values( #{score}, #{content}, #{user_id}, #{movieCd})")
	void review(ReviewDto review);
}


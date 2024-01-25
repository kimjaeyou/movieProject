package movieComm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import movieComm.dto.ReviewDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {
	
	@Select("select * from review")
	List<Map<String, String>>getList();
	
	@Insert("insert into review (score, content, user_id, movieCd,poster, movieTitle) values( #{score}, #{content}, #{user_id}, #{movieCd}, #{poster}, #{movieTitle})")
	void review(ReviewDto review);
	
	@Select("select user_id, content from review where movieCd = #{movieCd, jdbcType=VARCHAR}")
	List<Map<String, String>>getReview(String movieCd);
	
	@Select("select * from review where score=1")
	List<Map<String, String>>getP_1();

	@Select("select * from review where score=2")
	List<Map<String, String>>getP_2();
	
	@Select("select * from review where score=3")
	List<Map<String, String>>getP_3();
	
	@Select("select * from review where score=4")
	List<Map<String, String>>getP_4();
	
	@Select("select * from review where score=5")
	List<Map<String, String>>getP_5();
	
	@Select("SELECT * FROM review WHERE movieTitle LIKE '%${a}%'")
	List<Map<String, String>> getmovieTitle(String a);
	
	@Select("SELECT score FROM review WHERE movieTitle = #{movieTitle} AND movieCd=#{movieCd}")
	List<Integer> getScore(@Param(value="movieTitle")String movieTitle, @Param(value="movieCd")String movieCd);
	
}


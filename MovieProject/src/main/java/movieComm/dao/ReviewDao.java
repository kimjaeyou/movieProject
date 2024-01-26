package movieComm.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import movieComm.dto.ReviewDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {

	@Select("select * from review")
	List<Map<String, String>> getList();

	@Insert("insert into review (score, content, user_id, movieCd,poster, movieTitle) values( #{score}, #{content}, #{user_id}, #{movieCd}, #{poster}, #{movieTitle})")
	void review(ReviewDto review);

	@Select("select user_id, content from review where movieCd = #{movieCd, jdbcType=VARCHAR}")
	List<Map<String, String>> getReview(String movieCd);

	@Select("select * from review where score=1")
	List<Map<String, String>> getP_1();

	@Select("select * from review where score=2")
	List<Map<String, String>> getP_2();

	@Select("select * from review where score=3")
	List<Map<String, String>> getP_3();

	@Select("select * from review where score=4")
	List<Map<String, String>> getP_4();

	@Select("select * from review where score=5")
	List<Map<String, String>> getP_5();

	@Select("SELECT * FROM review WHERE movieTitle LIKE '%${a}%'")
	List<Map<String, String>> getmovieTitle(String a);

	@Select("SELECT score FROM review WHERE movieTitle = #{movieTitle} AND movieCd=#{movieCd}")
	List<Integer> getScore(@Param(value = "movieTitle") String movieTitle, @Param(value = "movieCd") String movieCd);

	@Select("SELECT * FROM review WHERE user_id ='${a}'")
	List<Map<String, String>> getUserId(String a);

	@Update("UPDATE review SET content=#{content}, score=#{score} WHERE review_id = #{review_id}")
	void update_review(@Param("content") String content, @Param("score") int score,
			@Param("review_id") String review_id);

	@Delete("DELETE FROM review WHERE review_id = #{review_id}")
	void delete_review(@Param("review_id") int review_id);

}

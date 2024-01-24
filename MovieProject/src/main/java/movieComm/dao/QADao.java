package movieComm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import movieComm.dto.QADto;

@Mapper
public interface QADao {
	
	@Insert("insert into QandA(qaID, qaTitle, content, userID, registeredDate) values(#{qaID}, #{qaTitle}, #{content}, #{userID}, now())")
	int insert(QADto dto);
	
	@Update("update QandA set readCount = readCount + 1 where qaID = #{qaID}")
	int addReadCount(int qaID);
	
	@Select("select * from QandA order by registeredDAte desc limit #{start}, #{count}")
	List<QADto> QAList(Map<String, Object> m);
	
	@Update("update QandA set content = #{content} where qaID = #{qaID}")
	int updateQA(QADto dto);
	
	@Select("select count(*) from QandA")
	int total();
	
	@Select("select * from QandA where qaID = #{qaID}")
	QADto QAContent(int qaID);
	
	@Delete("delete from QandA where qaID = #{qaID}")
	int deleteQA(int qaID);
	
	List<QADto> QAListSearch(Map<String, Object> m);
	int countSearch(Map<String, Object> m);
	
	@Select("select userID from QandA where qaID = #{qaID}")
	String QAUserID(int qaID);
}

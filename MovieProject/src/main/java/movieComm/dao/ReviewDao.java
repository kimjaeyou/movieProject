package movieComm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {

	@Select("select * from review")
	List<Map<String, String>>getList();
	
}
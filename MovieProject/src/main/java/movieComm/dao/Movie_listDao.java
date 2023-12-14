package movieComm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Movie_listDao {
	@Select("select movieNm,typeNm from movie_list")
	List<Map<String, String>> getList();
}

package movieComm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface movieContentDao {
	@Select("select title from moviecontent")
	List<Map<String, String>> getList();
}

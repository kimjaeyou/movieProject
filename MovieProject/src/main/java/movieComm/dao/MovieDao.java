package movieComm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import movieComm.DataStructure.MovieStructure;

@Mapper
public interface MovieDao {
	
	@Insert("insert into Movie (movieSeq, title, director, genre, poster) "
			+ "values( #{movieSeq}, #{title}, #{director}, #{genre}, #{poster})")
	void InsertMovie(MovieStructure data);
	
	@Select("select movieSeq from Movie")
	List<String> GetMovieSeq();
}

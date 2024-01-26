package movieComm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import movieComm.DataStructure.DaillyStructure;
import movieComm.DataStructure.MovieStructure;

@Mapper
public interface MovieDao {
	//MovieStruct
	@Insert("insert into Movie (movieSeq, title, director, genre, poster, DOCID) "
			+ "values( #{movieSeq}, #{title}, #{director}, #{genre}, #{poster}, #{DOCID})")
	void InsertMovie(MovieStructure data);
	
	@Select("select movieSeq from Movie")
	List<String> GetMovieSeq();

	@Select("select * from Movie")
	ArrayList<MovieStructure> GetMovies();
	
	@Select("select * from Movie where title like'%${str}%' ")
	ArrayList<MovieStructure> GetSearchs(String str);
	
	
	//daillyStruct
	@Insert("insert into Dailly (movieSeq, movieNm, poster, audiAcc, rankOldAndNew, `rank`) "
			+ "values( #{movieSeq}, #{movieNm}, #{poster}, #{audiAcc}, #{rankOldAndNew}, #{rank})")
	void InsertDailly(DaillyStructure data);
	
	@Select("SELECT * FROM Dailly ORDER BY CONVERT(`rank`, SIGNED);")
	ArrayList<DaillyStructure> GetDailly();
	
	@Delete("TRUNCATE TABLE Dailly")
	void truncate();
	
}

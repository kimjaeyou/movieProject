package movieComm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.DataFormating.DaillyFormat;
import movieComm.DataFormating.MovieFormat;
import movieComm.DataStructure.DaillyStructure;
import movieComm.DataStructure.MovieStructure;
import movieComm.dao.MovieDao;

@Service
public class MovieService {

	@Autowired
	MovieFormat format;

	@Autowired
	DaillyFormat dformat;

	@Autowired
	MovieDao mdao;

	boolean Seq_IsMatch(List<String> Seqlist, String Seq) {
		return !(Seqlist.contains(Seq));
	}

	public void movieDataInsert() {
		ArrayList<MovieStructure> movieData = new ArrayList<MovieStructure>();
		movieData = format.reMovies();
		for (MovieStructure data : movieData) {
			if (Seq_IsMatch(mdao.GetMovieSeq(), data.getMovieSeq()))
				mdao.InsertMovie(data);
		}
	}

	public ArrayList<MovieStructure> movieDataGet() {
		return mdao.GetMovies();
	}

	public void daillyDataInsert() {
		ArrayList<DaillyStructure> movieData = new ArrayList<DaillyStructure>();
		movieData = dformat.reDailly();
		mdao.truncate();
		for (DaillyStructure data : movieData) {
			mdao.InsertDailly(data);
		}
	}

	public ArrayList<DaillyStructure> daillyDataGet() {
		return mdao.GetDailly();
	}
}

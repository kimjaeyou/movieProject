package movieComm.DataStructure;

import lombok.Data;

@Data
public class DaillyStructure {
    String rank;
    String rankOldAndNew;
    String movieNm;
    String audiAcc;
    String poster;
    
    public DaillyStructure(String rank, String rankOldAndNew, String movieNm, String audiAcc, String poster) {
    	this.rank = rank;
    	this.rankOldAndNew = rankOldAndNew;
    	this.movieNm = movieNm;
    	this.audiAcc = audiAcc;
    	this.poster = poster;
	}
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import lombok.Data;
@Data
public class Movie {
	String DOCID;
	String movieId;
	String movieSeq;
	String title;
	String titleEng;
	String titleOrg;
	String titleEtc;
	String prodYear;
	String nation;
	String company;
	String runtime;
	String rating;
	String genre;
	String kmdbUrl;
	ArrayList<director> directors =  new ArrayList<director>();
	ArrayList<actor> actors =  new ArrayList<actor>();
	ArrayList<plot> plots =  new ArrayList<plot>();
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Movie {
	@JsonProperty("DOCID")
	String DOCID;

	@JsonProperty("movieId")
	String movieId;

	@JsonProperty("movieSeq")
	String movieSeq;

	@JsonProperty("title")
	String title;

	@JsonProperty("titleEng")
	String titleEng;

	@JsonProperty("titleOrg")
	String titleOrg;

	@JsonProperty("titleEtc")
	String titleEtc;
	
	@JsonProperty("statDate")
	String statDate;
	
	@JsonProperty("modDate")
	String modDate;

	@JsonProperty("prodYear")
	String prodYear;

	@JsonProperty("nation")
	String nation;

	@JsonProperty("company")
	String company;

	@JsonProperty("runtime")
	String runtime;

	@JsonProperty("rating")
	String rating;

	@JsonProperty("genre")
	String genre;

	@JsonProperty("kmdbUrl")
	String kmdbUrl;
	
	@JsonProperty("type")
	String type;
	
	@JsonProperty("use")
	String use;
	
	@JsonProperty("episodes")
	String episodes;	
	
	@JsonProperty("ratedYn")
	String ratedYn;
	
	@JsonProperty("repRatDate")
	String repRatDate;
	
	@JsonProperty("repRlsDate")
	String repRlsDate;
	
	@JsonProperty("keywords")
	String keywords;
	
	@JsonProperty("posters")
	String posters;

	@JsonProperty("stlls")
	String stlls;
	
	@JsonProperty("openThtr")
	String openThtr;
	
	@JsonProperty("screenArea")
	String screenArea;	
	
	@JsonProperty("screenCnt")
	String screenCnt;
	
	@JsonProperty("salesAcc")
	String salesAcc;
	
	@JsonProperty("audiAcc")
	String audiAcc;
	
	@JsonProperty("statSouce")
	String statSouce;
	
	@JsonProperty("themeSong")
	String themeSong;
	
	@JsonProperty("soundtrack")
	String soundtrack;
	
	@JsonProperty("fLocation")
	String fLocation;
	
	@JsonProperty("Awards1")
	String Awards1;
	
	@JsonProperty("Awards2")
	String Awards2;
	
	@JsonProperty("regDate")
	String regDate;
	
	@JsonProperty("ALIAS")
	String ALIAS;
	
	@JsonProperty("ratings")
	RatingWrapper ratings;
	
	@JsonProperty("staffs")
	StaffWrapper staffs;
	
	@JsonProperty("vods")
	VodWrapper vods;
	
	@JsonProperty("Codes")
	CodeWrapper Codes;
	
	@JsonProperty("CommCodes")
	CommCodeWrapper CommCodes;
	
	@JsonProperty("stat")
	ArrayList<Stat> stat;
	
	@JsonProperty("directors")
	DirectorWrapper directors;

	@JsonProperty("actors")
	ActorWrapper actors;

	@JsonProperty("plots")
	PlotWrapper plots;
}

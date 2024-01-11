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

	@JsonProperty("directors")
	DirectorWrapper directors;

	@JsonProperty("actors")
	ActorWrapper actors;

	@JsonProperty("plots")
	ArrayList<plot> plots = new ArrayList<>();
}

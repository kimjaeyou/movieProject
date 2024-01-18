package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rating {
	@JsonProperty("ratingMain")
	String ratingMain;

	@JsonProperty("ratingDate")
	String ratingDate;

	@JsonProperty("ratingNo")
	String ratingNo;

	@JsonProperty("ratingGrade")
	String ratingGrade;

	@JsonProperty("releaseDate")
	String releaseDate;

	@JsonProperty("runtime")
	String runtime;
}

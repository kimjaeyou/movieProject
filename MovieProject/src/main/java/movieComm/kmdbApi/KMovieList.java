package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KMovieList {
	@JsonProperty("Query")
	String Query;

	@JsonProperty("KMAQuery")
	String KMAQuery;

	@JsonProperty("TotalCount")
	int TotalCount;

	@JsonProperty("Data")
	ArrayList<Datalist> Data = new ArrayList<Datalist>();

}

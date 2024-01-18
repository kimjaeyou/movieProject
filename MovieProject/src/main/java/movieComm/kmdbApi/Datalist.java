package movieComm.kmdbApi;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Datalist {
	@JsonProperty("CollName")
	String CollName;
	
	@JsonProperty("TotalCount")
	int TotalCount;
	
	@JsonProperty("Count")
	int Count;
	
	@JsonProperty("Result")
	List<Movie> Result = new ArrayList<Movie>();
}

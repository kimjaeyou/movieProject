package movieComm.kmdbApi;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import lombok.Data;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KMovieList {
	String Query;
	String KMAQuery;
	int TotalCount;
	ArrayList<Datalist> Data =  new ArrayList<Datalist>();
	
}

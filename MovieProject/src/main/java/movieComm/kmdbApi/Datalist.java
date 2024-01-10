package movieComm.kmdbApi;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Datalist {
	String CollName;
	int TotalCount;
	int Count;
	ArrayList<Movie> Result =  new ArrayList<Movie>();
}

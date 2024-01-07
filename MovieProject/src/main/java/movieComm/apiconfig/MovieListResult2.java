package movieComm.apiconfig;

import java.util.ArrayList;

import lombok.Data;
@Data
public class MovieListResult2 {
	String boxofficeType;
    String showRange;

    ArrayList<Movie2> dailyBoxOfficeList = new ArrayList<Movie2>();
}

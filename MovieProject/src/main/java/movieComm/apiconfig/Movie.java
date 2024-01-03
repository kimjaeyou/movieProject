package movieComm.apiconfig;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class Movie {
    String movieCd;
    String movieNm;
    String movieNmEn;
    String prdYear;
    String openDt;
    String typeNm;
    String prdtStatNm;
    String nationAlt;
    String genreAlt;
    String repNationNm;
    String repGenreNm;
    List<Director> directors = new ArrayList<Director>();
    List<Company> companys = new ArrayList<Company>();
}
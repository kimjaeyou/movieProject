package movieComm.apiconfig;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Movie3 {
	String movieCd;
	String movieNm;
	String movieNmEn;
	String movieNmOg;
	String showTm;
	String prdtYear;
	String openDt;
	String prdtStatNm;
	String typeNm;
	List<Nation> nations = new ArrayList<Nation>();
	List<Genre> genres = new ArrayList<Genre>();
	List<Director2> directors = new ArrayList<Director2>();
	List<Actor> actors = new ArrayList<Actor>();
	List<ShowType> showTypes= new ArrayList<ShowType>();
	List<Company2> companys = new ArrayList<Company2>();
	List<Audit> audits = new ArrayList<Audit>();
	List<Staff> staffs = new ArrayList<Staff>();
}

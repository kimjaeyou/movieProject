package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Stat {
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

	@JsonProperty("statDate")
	String statDate;
}

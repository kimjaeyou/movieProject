package movieComm.kmdbApi;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Plot {
	
	@JsonProperty("plotLang")
	String plotLang;
	
	@JsonProperty("plotText")
	String plotText;
	
}

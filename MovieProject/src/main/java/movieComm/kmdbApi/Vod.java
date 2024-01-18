package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Vod {
	@JsonProperty("vodClass")
	String vodClass;

	@JsonProperty("vodUrl")
	String vodUrl;
}

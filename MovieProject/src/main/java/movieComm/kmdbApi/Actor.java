package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Actor {
	@JsonProperty("actorNm")
	String actorNm;

	@JsonProperty("actorEnNm")
	String actorEnNm;

	@JsonProperty("actorId")
	String actorId;
}

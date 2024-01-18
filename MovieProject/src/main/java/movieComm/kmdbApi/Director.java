package movieComm.kmdbApi;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Director {
	
	@JsonProperty("directorNm")
    String directorNm;

    @JsonProperty("directorEnNm")
    String directorEnNm;

    @JsonProperty("directorId")
    String directorId;
}

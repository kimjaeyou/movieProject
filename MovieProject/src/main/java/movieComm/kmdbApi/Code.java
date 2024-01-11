package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Code {
	@JsonProperty("CodeNm")
	String codeNm;

	@JsonProperty("CodeNo")
	String codeNo;
}

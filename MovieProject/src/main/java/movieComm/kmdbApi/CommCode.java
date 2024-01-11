package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class CommCode {
	@JsonProperty("CodeNm")
	String codeNm;

	@JsonProperty("CodeNo")
	String codeNo;
}

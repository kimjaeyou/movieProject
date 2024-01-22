package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data 
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommCode {
	@JsonProperty("CodeNm")
	String codeNm;

	@JsonProperty("CodeNo")
	String codeNo;
	
	public CommCode(){
		this.codeNm = "Default";
        this.codeNo = "Default";
	}
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class CodeWrapper {
	@JsonProperty("Code")
	ArrayList<Code> code;
}

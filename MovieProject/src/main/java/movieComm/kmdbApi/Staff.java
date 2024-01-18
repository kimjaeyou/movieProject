package movieComm.kmdbApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Staff {
	@JsonProperty("staffNm")
	String staffNm;

	@JsonProperty("staffEnNm")
	String staffEnNm;

	@JsonProperty("staffRoleGroup")
	String staffRoleGroup;

	@JsonProperty("staffRole")
	String staffRole;

	@JsonProperty("staffEtc")
	String staffEtc;

	@JsonProperty("staffId")
	String staffId;
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VodWrapper {
	@JsonProperty("vod")
	ArrayList<Vod> vod;
}

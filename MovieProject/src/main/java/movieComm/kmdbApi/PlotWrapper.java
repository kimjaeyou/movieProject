package movieComm.kmdbApi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlotWrapper {
	@JsonProperty("plot")
	List<Plot> plot;
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlotWrapper {
	@JsonProperty("plot")
	ArrayList<Plot> plot;
}

package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActorWrapper {
	@JsonProperty("actor")
	ArrayList<Actor> actor;
}

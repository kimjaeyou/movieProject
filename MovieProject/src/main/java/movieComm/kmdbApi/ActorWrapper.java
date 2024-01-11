package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorWrapper {
	@JsonProperty("actor")
	ArrayList<Actor> actor;
}

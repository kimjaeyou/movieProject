package movieComm.kmdbApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffWrapper {
	@JsonProperty("staff")
	ArrayList<Staff> staff;
}

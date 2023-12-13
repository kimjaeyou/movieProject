package movieComm.dto;

import lombok.Data;

@Data
public class UserDto {
	private String user_id;
	private String user_pw;
	private String gender;
	private int age;
	private String phoneNum;
}

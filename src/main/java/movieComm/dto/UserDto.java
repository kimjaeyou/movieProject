package movieComm.dto;

import lombok.Data;

@Data
public class UserDto {
	private String user_id;
	private String user_pw;
	private String user_sex;
	private int user_age;
	private String phoneNum;
	private String user_address;
}

package movieComm.dto;

import lombok.Data;

@Data
public class UserDto {
	private String user_id;
	private String user_pw;
	private boolean user_sex;
	private int age;
	private String usesr_phoneNum;
	private String address;
}

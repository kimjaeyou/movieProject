package movieComm.dto;

import java.util.Date;

import lombok.Data;

@Data
public class QADto {
	private String qaID;
	private String qaTitle;
	private String content;
	private String userID;
	private Date registeredDate;
	private int readCount;
}

package movieComm.dto;

import lombok.Data;

@Data
public class QandADto {
	private int qaID;
	private String qaTitle;
	private String userName;
	private String requestDate;
	private String content;

	
	public QandADto() {	}
	
	public QandADto(int qaID, String qaTitle, String userName, String requestDate, String content) {
		this.qaID = qaID; 
		this.qaTitle = qaTitle;
		this.userName = userName;
		this.requestDate = requestDate;
		this.content = content;
				
	}
}

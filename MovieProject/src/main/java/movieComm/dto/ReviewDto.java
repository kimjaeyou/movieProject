package movieComm.dto;

import lombok.Data;

@Data
public class ReviewDto {
	private int review_id;
	private int score;
	private String content;
	private String user_id;
	private String movieCd;
}

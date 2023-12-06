package movieComm.dto;

import lombok.Data;

@Data
public class SeatDto {
	private String seat_id;
	private String theater_id;
	private String user_id;
	private String movie_order_id;
}

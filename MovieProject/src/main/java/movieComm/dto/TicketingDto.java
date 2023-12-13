package movieComm.dto;

import lombok.Data;

@Data
public class TicketingDto {
	private int ticket_id;
	private int price;
	private String seat_id;
	private String user_id;
	private String movieCd;
}

package com.example.commands;

import java.util.List;
import lombok.Data;

@Data
public class OrderCommand {
	private List<OrderItem> orderItems;
	private Address address;
}
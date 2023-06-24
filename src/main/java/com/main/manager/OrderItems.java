package com.main.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
	
	private OrderCatagory orderCatagory;
	
	private long totalItems;
	
	private long price;
	
}

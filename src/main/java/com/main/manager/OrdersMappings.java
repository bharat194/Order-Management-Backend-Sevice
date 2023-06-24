package com.main.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersMappings {
	
	@Autowired
	private final OrdersService orderService;
	
	public OrdersMappings(OrdersService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/")
	public String sayHey() {
		return "You are checking Orders";
	}
	
	@GetMapping("/get/{id}")
	public CustomerOrders getOrder(@PathVariable String id) {
		return orderService.getOrder(id);
	}
	
	@PostMapping("/addOrder/{customerId}")
	public String addOrder(@PathVariable String customerId,@RequestBody CustomerOrders order) {
		if(orderService.addOrder(customerId,order)) {
			return "Order Added";
		}else {
			return "Unsuffient amount";
		}
	}

}

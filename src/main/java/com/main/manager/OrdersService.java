package com.main.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	private final OrdersRepo ordersRepo;
	
	@Autowired
	DataGenerator dataGenerator;
	
	@Autowired
	CustomerRepo customerRepo;
	
	public OrdersService(OrdersRepo ordersRepo) {
		super();
		this.ordersRepo = ordersRepo;
	}
	
	public boolean addOrder(String id,CustomerOrders order) {
		CustomerData curCustomerData = customerRepo.findById(id).get();
		if(curCustomerData.getWallet().getAmount() < order.getItems().getPrice()) {
			return false;
		}else {
			order.setUserId(id);
			order.setOrderId(dataGenerator.generateId());
			curCustomerData.getOrders().add(order.getOrderId());
			curCustomerData.getWallet().setAmount(curCustomerData.getWallet().getAmount()-order.getItems().getPrice());
			ordersRepo.save(order);
			return true;
		}
		
	}
	
	public CustomerOrders getOrder(String id) {
		return ordersRepo.findById(id).get();
	}
}

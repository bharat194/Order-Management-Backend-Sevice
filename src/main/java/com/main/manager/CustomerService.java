package com.main.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired 
	private final CustomerRepo customerRepo;
	
	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	DataGenerator datagenerator;
	
	@Autowired
	PasswordGenerator passwordGenerator;
	
	public CustomerService(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public CustomerData getCustomer(String id) {
		return customerRepo.findById(id).get();
	}
	
	public List<CustomerData> getAllUsers(){
		return customerRepo.findAll();
	}
	
	public void addAmount(String customerId, Wallet wallet) {
		CustomerData customerData = customerRepo.findById(customerId).get();
		customerData.getWallet().setAmount(customerData.getWallet().getAmount()+wallet.getAmount());
		customerRepo.deleteById(customerId);
		customerRepo.save(customerData);
	}
	
	public List<CustomerOrders> getAllOrders(String customerId){
		List<CustomerOrders> resCustomerOrders = new ArrayList<>();
		customerRepo.findById(customerId).get().getOrders().forEach(i->{
			 resCustomerOrders.add(ordersRepo.findById(i).get());
		});
		return resCustomerOrders;
	}
	
	public CustomerData createCustomer(CustomerData customerData) {
		customerData.setPassword(passwordGenerator.encrypt(customerData.getPassword()));
		customerData.setUnique(datagenerator.generateId());
		return customerRepo.save(customerData);
	}
	
	public void addRandomCustomers() {
		for(int i=0;i<10;i++) {
			CustomerData newCustomer = datagenerator.generateCustomer();
			newCustomer.setPassword(passwordGenerator.encrypt(newCustomer.getPassword()));
			customerRepo.save(newCustomer);
		}
	}

}

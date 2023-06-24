package com.main.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "You are checcking Customer Data";
	}
	
	@GetMapping("/add")
	public String addCostumers() {
		customerService.addRandomCustomers();
		return "Random Customers Added";
	}
	
	@PostMapping("/addAmount/{customerId}")
	public String addAmount(@PathVariable String customerId,@RequestBody Wallet wallet) {
		customerService.addAmount(customerId,wallet);
		return "Amount Added";
	}
	
	@GetMapping("/getAll")
	public List<CustomerData> getAll(){
		return customerService.getAllUsers();
	}
	
	@GetMapping("/get/{id}")
	public CustomerData getCustomerById(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/getAllOrders/{customerId}")
	public List<CustomerOrders>  getAllOrders(@PathVariable String customerId){
		return customerService.getAllOrders(customerId);
	}
	
	@PostMapping("/add")
	public CustomerData createCustomer(@RequestBody CustomerData customerData) {
		return customerService.createCustomer(customerData);
	}
	
	
	
}

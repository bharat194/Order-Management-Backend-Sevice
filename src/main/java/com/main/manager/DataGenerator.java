package com.main.manager;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class DataGenerator {
	Faker faker = new Faker();
	public String generateId() {
		return faker.numerify("######");
	}
	public CustomerData generateCustomer() {
		String email = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3)+"@gmail.com";
		String contactNumber = faker.phoneNumber().cellPhone();
		String password = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3);
		String id = faker.numerify("######");
		CustomerAddress address=  new CustomerAddress(faker.address().city(),faker.address().country());
		CustomerData cur = new CustomerData(id,email,password,contactNumber,new Wallet(0),address,new ArrayList<>());
		return cur;
	}

}

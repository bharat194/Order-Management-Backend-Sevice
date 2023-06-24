package com.main.manager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<CustomerOrders,String>{

}

package com.main.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CustomerOrders {
	
	@Id @Column(name ="id", unique = true) private String orderId;
	
	@Column(name ="userid") private String userId;
	
	@Enumerated(EnumType.STRING) @Column(name="status") private OrderStatus status;
	
	@Type(type = "jsonb") @Column(columnDefinition = "jsonb") private OrderItems items;

	public CustomerOrders(OrderStatus status, OrderItems items) {
		super();
		this.userId = null;
		this.status = status;
		this.items = items;
	}

}

package com.main.manager;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class CustomerData {
	
	@Id @Column(name="unique") private String unique;

	@Column(unique = true) private String email;
	
	@Column(name="Customer Password") private String password;
	
	@Column(name="Customer ContactNumber") private String contactNumber;
	
	@Type(type = "jsonb") @Column(name="Wallet" ,columnDefinition = "jsonb") private Wallet wallet;
	
	@Type(type = "jsonb") @Column(name ="address" ,columnDefinition = "jsonb") private CustomerAddress address;
	
	@Type(type = "jsonb") @Column(name = "All orders", columnDefinition = "jsonb") private ArrayList<String> orders;
	
}

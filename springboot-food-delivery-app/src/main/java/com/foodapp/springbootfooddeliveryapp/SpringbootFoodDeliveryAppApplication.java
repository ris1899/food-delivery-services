package com.foodapp.springbootfooddeliveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.activation.DataSource;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringbootFoodDeliveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFoodDeliveryAppApplication.class, args);
	}

}

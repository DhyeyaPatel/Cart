package com.example.ShoppingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@Sql({"/employees_schema.sql", "/import_employees.sql"})
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}

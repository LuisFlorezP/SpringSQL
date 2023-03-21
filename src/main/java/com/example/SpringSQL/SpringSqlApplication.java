package com.example.SpringSQL;

import com.example.SpringSQL.controllers.Page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringSqlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringSqlApplication.class, args);

		Page page = new Page();
		page.Menu();

		//context.close();
	}
}

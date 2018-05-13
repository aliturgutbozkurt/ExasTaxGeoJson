package com.exastax.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.exastax.assignment.manager.BootstrapManager;

@SpringBootApplication
@PropertySource("classpath:/configuration.properties")
public class SalesDataExasTaxApplication implements CommandLineRunner {
	
	private final BootstrapManager bootstrapManager;
	
	public SalesDataExasTaxApplication(BootstrapManager bootstrapManager) {
		this.bootstrapManager=bootstrapManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(SalesDataExasTaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bootstrapManager.loadCsvSalesData();
	}
}

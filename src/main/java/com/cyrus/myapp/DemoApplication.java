package com.cyrus.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean // CommandLineRunner is a functional interface, so we can use a lambda
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // Add sample products
            System.out.println("Adding sample products...");
			productRepository.save(new Product(0, "laptop", 999));
			productRepository.save(new Product(1, "Wireless Mouse", 20));
			productRepository.save(new Product(2, "Keyboard", 30));
			productRepository.save(new Product(3, "Monitor", 150));
			productRepository.save(new Product(4, "Headphones", 50));

			loginRepository.save(new Login("johndoe@example.com", passwordEncoder.encode("password123")));

            System.out.println("Sample products added. Count: " + productRepository.count());
        };
    }
}

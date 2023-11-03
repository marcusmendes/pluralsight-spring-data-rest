package com.pluralsight.springdatarest;

import com.pluralsight.springdatarest.beans.CsvDataLoader;
import com.pluralsight.springdatarest.model.Auction;
import com.pluralsight.springdatarest.model.User;
import com.pluralsight.springdatarest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CsvDataLoader.class)
public class SpringdatarestApplication {

	@Autowired
	private Auction auction;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatarestApplication.class, args);
	}

	@Bean
	ApplicationRunner configureRepository(UserRepository userRepository) {
		return args -> {
			for (User user : auction.getUsers()) {
				userRepository.save(user);
			}
		};
	}
}

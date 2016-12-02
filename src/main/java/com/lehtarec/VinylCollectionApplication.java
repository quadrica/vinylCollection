package com.lehtarec;

import com.lehtarec.domain.User;
import com.lehtarec.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class VinylCollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(VinylCollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VinylCollectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
		return (args) -> {
			//if you need to create records showed below in database, just remove '/*' and '*/'

			// Create users: admin/admin user/user
			//created
			/*
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			*/

			// Insert some demo data
			//created
			/*
			jdbcTemplate.update("insert into VC_Release(title, artist) values (?, ?)", "Play", "Moby");
			jdbcTemplate.update("insert into VC_Release(title, artist) values (?, ?)", "The fat of the land", "Prodigy");
			jdbcTemplate.update("insert into VC_Release(title, artist) values (?, ?)", "Strobe", "Deadmau5");
			*/
		};
	}
}

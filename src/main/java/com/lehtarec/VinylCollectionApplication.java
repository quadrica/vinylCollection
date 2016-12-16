package com.lehtarec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lehtarec.domain.UserRepository;

@SpringBootApplication
public class VinylCollectionApplication {

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
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "Play", "Moby", "https://img.discogs.com/XA7aB3jeY5-Ng3Dw2RBc-nQ84yQ=/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-55313-1345254572-7258.jpeg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "The fat of the land", "Prodigy", "https://img.discogs.com/nKn-gfB_8X7lahTiRoEKNatfGug=/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-26194-1300100128.jpeg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "Strobe", "Deadmau5", "https://www.discogs.com/release/2094514-Strobe/images");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "Sur La Terre", "Martin Solveig", "https://img.discogs.com/galRit8mAFRTu3ltpQTwlHlVHyM=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-439091-1168601961.jpeg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "You've come a long way baby", "Fatboy Slim", "https://img.discogs.com/Lp4PgC66qCjBBksAPI-E0NpW-00=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-2704-1119125576.jpg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "Goodbye country (Hello nightclub)", "Groove Armada", "https://img.discogs.com/NkcDaIfaTET7UC5lb6Ho0uwIvow=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-697346-1247777129.jpeg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "The man with the red face", "Laurent Garnier", "https://img.discogs.com/lWIckD0nkdzcMl1We_cPKSJDzt8=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-694-1447722482-9902.jpeg.jpg");
			jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", "Mondo Beyondo", "Ursula 1000", "https://img.discogs.com/u7lzJP435vCluLE0Y3vc-aUuVXk=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-3059773-1313820672.jpeg.jpg");
			*/
		};
	}
}

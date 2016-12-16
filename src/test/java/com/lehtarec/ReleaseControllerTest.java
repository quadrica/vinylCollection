package com.lehtarec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.lehtarec.domain.Release;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReleaseControllerTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	//Check how release creation/inserting to DB/getting from DB/ DB connection works
	@Test
	public void createNewRelease() {
		Release release = new Release("RePlay", "ReMoby", "http://instagram.com/remoby_replay.jpg");
		jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", release.getTitle(), release.getArtist(), release.getImgurl());
		
		Long id = (Long) jdbcTemplate.queryForObject("select id from VC_Release where artist = 'ReMoby' and title = 'RePlay'", (resultSet, i) -> {
			
			return resultSet.getLong(1);
		});
		assertThat(id != null);
	}
	
	@Test 
	public void adminAndUserRolesExistInDb() {
		int adminCount = (int) jdbcTemplate.queryForObject("select count(*) from user where role = 'ADMIN'", (resultSet, i) -> {
			
			return resultSet.getInt(1);
		});
		System.out.println("There are " + adminCount + " users who has role 'ADMIN' in database.");
		assertThat(adminCount != 0);
		int userCount = (int) jdbcTemplate.queryForObject("select count(*) from user where role = 'USER'", (resultSet, i) -> {
			
			return resultSet.getInt(1);
		});
		System.out.println("There are " + userCount + "users who has role 'USER' in database.");
		assertThat(userCount != 0);
	}
}

package team.rj.swms.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import team.rj.swms.domain.User;

@Component
public class UserDAO {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* * * * * * INSERTING A NEW USER * * * * * */
	
	public void saveUser(User user) {

		String sql = "INSERT INTO user(name, username, password, email) VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getPassword(), user.getEmail());
	}
}

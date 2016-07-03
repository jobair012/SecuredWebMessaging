package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import model.Users;

@Component
public class UsersDao {

	private JdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private void setDataSource(DataSource dataSource) {

		this.jdbc = new JdbcTemplate(dataSource);
	}

	/** * * * * INSERT USER * * * * **/
	public boolean saveUser(Users user) {

		String sql = "INSERT INTO users (username, password, role, enabled, name, email, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";

		String encodedPassword = passwordEncoder.encode(user.getPassword());

		return jdbc.update(sql, user.getUsername(), encodedPassword, user.getRole(), user.isEnabled(), user.getName(),
				user.getEmail(), user.getGender()) == 1;
	}

}

package team.rj.swms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import team.rj.swms.domain.UserKeys;

@Component
public class UserKeysDAO {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* * * * * * SAVING A NEW MESSAGE * * * * * */

	public void saveKeys(UserKeys userKeys) {

		String sql = "INSERT INTO userKeys(key_N, key_E, key_D, user_username) VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(sql, userKeys.getKey_N(), userKeys.getKey_E(), userKeys.getKey_D(),
				userKeys.getUser_username());
	}

	/* * * * * * SHOW KEYS OF PARTICULAR USER * * * * * */

	public UserKeys getKeysOfParticularUser(String username) {

		String sql = "SELECT * FROM userKeys WHERE user_username = '" + username + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<UserKeys>() {

			@Override
			public UserKeys extractData(ResultSet resultSet) throws SQLException, DataAccessException {

				if (resultSet.next()) {

					UserKeys userKeys = new UserKeys();

					userKeys.setKey_N(resultSet.getString("key_N"));
					userKeys.setKey_E(resultSet.getString("key_E"));
					userKeys.setKey_D(resultSet.getString("key_D"));

					return userKeys;

				}

				else {
					return null;
				}
			}

		});
	}

}

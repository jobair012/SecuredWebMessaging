package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import model.UserKeys;

@Component
public class KeysDao {

	private JdbcTemplate jdbc;

	@Autowired
	private void setDataSource(DataSource dataSource) {

		this.jdbc = new JdbcTemplate(dataSource);
	}

	/** * * * * SAVE USERKEYS * * * * **/
	public boolean saveKey(UserKeys userKeys) {

		String sql = "INSERT INTO userKeys (key_N, key_E, key_D, username) VALUES (?, ?, ?, ?)";

		return jdbc.update(sql, userKeys.getKey_N(), userKeys.getKey_E(), userKeys.getKey_D(),
				userKeys.getUsername()) == 1;
	}

	/** * * * * GETTING A PARTICULAR USER WITH username Parameter * * * * **/
	public UserKeys getKeys(String username) {

		String sql = "SELECT * FROM userKeys WHERE username = '" + username+ "'";

		return jdbc.query(sql, new ResultSetExtractor<UserKeys>() {

			@Override
			public UserKeys extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					UserKeys keys = new UserKeys();

					keys.setKey_N(rs.getString("key_N"));
					keys.setKey_E(rs.getString("key_E"));
					keys.setKey_D(rs.getString("key_D"));

					return keys;
				}

				else {
					return null;
				}
			}
		});
	}

}
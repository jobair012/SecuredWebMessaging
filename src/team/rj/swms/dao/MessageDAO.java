package team.rj.swms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import team.rj.swms.domain.Message;

@Component
public class MessageDAO {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* * * * * * SAVING A NEW MESSAGE * * * * * */

	public void saveMessage(Message message) {

		String sql = "INSERT INTO message(subject, message, date, sender, receiver) VALUES (?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, message.getSubject(), message.getMessage(), message.getDate(), message.getSender(),
				message.getReceiver());
	}

	/* * * * * * GET ALL MESSAGES * * * * * */
	public List<Message> getAllMessages(String username) {

		String sql = "SELECT * FROM message WHERE receiver = '" + username + "' AND trash = 0 ORDER BY messageId DESC";

		return jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet resultSet, int rowNum) throws SQLException {

				Message message = new Message();

				message.setMessageId(resultSet.getInt("messageId"));
				message.setSender(resultSet.getString("sender"));
				message.setSubject(resultSet.getString("subject"));
				message.setDate(resultSet.getString("date"));

				return message;
			}

		});
	}

	/* * * * * * GET DETAILS OF PARTICULAR MESSAGES * * * * * */

	public Message getDetailsOfParticularMessage(int messageId, String sender, String receiver) {

		String sql = "SELECT * FROM message WHERE messageId = " + messageId + " AND sender = '" + sender
				+ "' AND receiver = '" + receiver + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Message>() {

			@Override
			public Message extractData(ResultSet resultSet) throws SQLException, DataAccessException {

				if (resultSet.next()) {

					Message message = new Message();

					message.setMessage(resultSet.getString("message"));
					message.setSender(resultSet.getString("sender"));
					message.setSubject(resultSet.getString("subject"));
					message.setDate(resultSet.getString("date"));

					return message;

				}

				else {
					return null;
				}
			}

		});
	}
}

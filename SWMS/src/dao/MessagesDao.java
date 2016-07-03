package dao;

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

import model.Messages;

@Component
public class MessagesDao {

	private JdbcTemplate jdbc;

	@Autowired
	private void setDataSource(DataSource dataSource) {

		this.jdbc = new JdbcTemplate(dataSource);
	}

	/** * * * * SAVE RECEIVED MESSAGES * * * * **/
	public boolean saveMessageOnReceived(Messages message) {

		String sql = "INSERT INTO receivedItems (time, sender, receiver, trashed, subject, message) VALUES (?, ?, ?, ?, ?, ?)";

		return jdbc.update(sql, message.getTime(), message.getSender(), message.getReceiver(), message.isTrashed(),
				message.getSubject(), message.getMessage()) == 1;
	}

	/** * * * * SAVE SENT MESSAGES * * * * **/
	public boolean saveMessageOnSent(Messages message) {

		String sql = "INSERT INTO sentItems (time, sender, receiver, subject, message) VALUES (?, ?, ?, ?, ?)";

		return jdbc.update(sql, message.getTime(), message.getSender(), message.getReceiver(), message.getSubject(),
				message.getMessage()) == 1;
	}

	/** * * * * ALL RECEIVED MESSAGE OF A PARTICULAR USER * * * * **/
	public List<Messages> getAllMessages(String username) {

		String sql = "SELECT * FROM receivedItems WHERE receiver = '" + username
				+ "' AND trashed = 0 ORDER BY receiveItemId DESC";

		return jdbc.query(sql, new RowMapper<Messages>() {

			@Override
			public Messages mapRow(ResultSet rs, int rowNum) throws SQLException {

				Messages message = new Messages();

				message.setMessageId(rs.getInt("receiveItemId"));
				message.setSubject(rs.getString("subject"));
				message.setSender(rs.getString("sender"));
				message.settime(rs.getString("time"));

				return message;
			}
		});
	}

	/** * * * * DETAIL OF A PARTICULAR MESSAGE * * * * **/
	public Messages getMessage(int id, String sender, String receiver) {

		String sql = "SELECT * FROM receivedItems WHERE receiveItemId = " + id + " AND sender = '" + sender
				+ "' AND receiver = '" + receiver + "'";

		return jdbc.query(sql, new ResultSetExtractor<Messages>() {

			@Override
			public Messages extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Messages message = new Messages();

					message.setMessageId(rs.getInt("receiveItemId"));
					message.setSubject(rs.getString("subject"));
					message.setSender(rs.getString("sender"));
					message.settime(rs.getString("time"));
					message.setMessage(rs.getString("message"));

					return message;
				} else {

					return null;
				}
			}

		});
	}

	public List<Messages> getAllSentMessages(String username) {

		String sql = "SELECT * FROM sentItems WHERE sender = '" + username + "' ORDER BY sentItemsId DESC";

		return jdbc.query(sql, new RowMapper<Messages>() {

			@Override
			public Messages mapRow(ResultSet rs, int rowNum) throws SQLException {

				Messages message = new Messages();

				message.setMessageId(rs.getInt("sentItemsId"));
				message.setSubject(rs.getString("subject"));
				message.setReceiver(rs.getString("receiver"));
				message.settime(rs.getString("time"));

				return message;
			}

		});
	}

	public Messages getSentMessages(int id, String sender, String receiver) {
		String sql = "SELECT * FROM sentItems WHERE sentItemsId = " + id + " AND sender = '" + sender
				+ "' AND receiver = '" + receiver + "'";
		
		return jdbc.query(sql, new ResultSetExtractor<Messages>() {

			@Override
			public Messages extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Messages message = new Messages();

					message.setMessageId(rs.getInt("sentItemsId"));
					message.setSubject(rs.getString("subject"));
					message.setReceiver(rs.getString("receiver"));
					message.settime(rs.getString("time"));
					message.setMessage(rs.getString("message"));

					return message;
				} else {

					return null;
				}
			}

		});
	}
}

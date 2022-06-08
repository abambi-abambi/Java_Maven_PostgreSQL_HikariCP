package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.models.Chatroom;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.dataSource = ds;
    }

    User user = new User(1L, "abambi", "12345", null, null);
    Chatroom chatroom = new Chatroom(1L, "hello_world", null, null);

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement query = conn.prepareStatement("SELECT * FROM chat.messages WHERE id=?;");
        query.setLong(1, id);
        ResultSet resultSet = query.executeQuery();
        if (resultSet.next() == false) { // add throws SQLException
            System.out.println("Error: resultSet is false");
            System.exit(-1);
        }
        Message msg = new Message(
                    resultSet.getLong("id"),
                    user,
                    chatroom,
                    resultSet.getString("text"),
                    resultSet.getTimestamp("data").toLocalDateTime());
        query.close();
        conn.close();
        Optional<Message> res_msg = Optional.ofNullable(msg);
        return (res_msg);
    }
}
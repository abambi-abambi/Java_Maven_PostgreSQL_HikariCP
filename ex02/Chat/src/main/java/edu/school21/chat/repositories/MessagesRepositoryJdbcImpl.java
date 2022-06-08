package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.exception.NotSavedSubEntityException;

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
        if (resultSet.next() == false) { // add throws SQLException  // query.close();conn.close();
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

    @Override
    public void save(Message message) throws NotSavedSubEntityException, SQLException {
        Connection conn;
        PreparedStatement query;
        Long    found_id;
        String  new_text = "'" + message.getText() + "'";
        Long    author_id = message.getAuthor().getId();
        Long    chatroom_id = message.getChatroom().getId();
        String  new_time = "'" + message.MessageDateTime() + "'";

        String sqlRequest =
        "INSERT INTO chat.messages (author, room, text, data) " +
                "VALUES (" + chatroom_id + ", " + author_id + ", " + new_text + ", " + new_time + ") RETURNING id;";

        try {
            conn = dataSource.getConnection();
            query = conn.prepareStatement(sqlRequest);
            ResultSet   resultSet = query.executeQuery();
            if (resultSet.next()) {
                found_id = resultSet.getLong("id");
                message.setId(found_id);
            }
        } catch (SQLException e) {
            throw new NotSavedSubEntityException(); // query.close();conn.close();
        }
        query.close();
        conn.close();
    }
}
package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.exception.NotSavedSubEntityException;

import java.util.Optional;
import java.sql.SQLException;

public interface MessagesRepository {
    Optional<Message> findById(Long id) throws SQLException;
    public void save(Message message) throws NotSavedSubEntityException, SQLException;
}
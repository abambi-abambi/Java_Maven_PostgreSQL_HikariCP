package edu.school21.chat.app;

import edu.school21.chat.models.User; //
import edu.school21.chat.models.Chatroom; //
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;//
import java.time.LocalDateTime;
import java.util.Optional;

public class Program {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "abambi4";
    private static final String pwd = "pabambi4";

    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pwd);

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);
        Optional<Message> messageOptional = repository.findById(11L);
        if (!messageOptional.isPresent()) {
            System.out.println("Message is not found");
            System.exit(0);
        }
        Message message = messageOptional.get();
        message.setText("Bye");
        message.setMessageDateTime(LocalDateTime.now());
        repository.update(message);

        System.out.println(message.getId());
    }
}
package edu.school21.chat.app;

import edu.school21.chat.repositories.*;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;

import java.io.File;
import java.io.FileNotFoundException;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.Scanner;

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

        User        author = new User(1L, "user1", "passw1", new ArrayList<>(), new ArrayList<>());
        Chatroom    room = new Chatroom(2L, "General", author, new ArrayList<>());
        Message     msg = new Message(null, author, room, "What a beautiful world!", LocalDateTime.now());

        repository.save(msg);
        System.out.println(msg.getId());
    }
}
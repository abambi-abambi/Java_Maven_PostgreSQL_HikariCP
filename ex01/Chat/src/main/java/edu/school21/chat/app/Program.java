package edu.school21.chat.app;

import edu.school21.chat.repositories.*;
import edu.school21.chat.models.Message;

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
//import java.util.Optional;

public class Program {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "abambi4";
    private static final String pwd = "pabambi4";

    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pwd);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID\n-> ");
        Long id = scanner.nextLong();

        MessagesRepository repository = new MessagesRepositoryJdbcImpl((DataSource)ds);
        Message res = repository.findById(id).get();
        System.out.println(res);

        scanner.close();
    }
}
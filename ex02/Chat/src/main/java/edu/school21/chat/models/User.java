package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> usedRooms;

    public User() {
        this.id = null;
        this.login = null;
        this.password = null;
        this.createdRooms = null;
        this.usedRooms = null;
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = null;
        this.usedRooms = null;
    }

    public User(Long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> usedRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.usedRooms = usedRooms;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }
    public void setUsedRooms(List<Chatroom> usedRooms) {
        this.usedRooms = usedRooms;
    }

    public long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }
    public List<Chatroom> getUsedRooms() {
        return usedRooms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                createdRooms.equals(user.createdRooms) &&
                usedRooms.equals(user.usedRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, usedRooms);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", usedRooms=" + usedRooms +
                '}';
    }
}
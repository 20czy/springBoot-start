package com.example.demo.entity;

public class Traveller {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

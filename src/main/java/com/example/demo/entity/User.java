package com.example.demo.entity;

public class User {
    String name;
    String passWord;

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

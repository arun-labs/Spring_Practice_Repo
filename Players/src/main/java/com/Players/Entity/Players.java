package com.Players.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Players {
    private String id;
    private String name;
    private int age;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Players(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Players(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Players() {
    }

    

    
}

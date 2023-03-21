package com.example.SpringSQL.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "userOne")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    @Column(name = "name_user")
    private String name_user;
    @Column(name = "age_user")
    private int age_user;

    public User() {
    }

    public User(String name_user, int age_user) {
        this.name_user = name_user;
        this.age_user = age_user;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public int getAge_user() {
        return age_user;
    }

    public void setAge_user(int age_user) {
        this.age_user = age_user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", name_user='" + name_user + '\'' +
                ", age_user=" + age_user +
                '}';
    }
}

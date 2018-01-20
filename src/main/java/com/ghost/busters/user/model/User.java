package com.ghost.busters.user.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;

    }

    public Long getUser_id() {
        return id;
    }

    public void setUser_id(Long user_id) {
        this.id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
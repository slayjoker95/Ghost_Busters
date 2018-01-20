package com.ghost.busters.hunter.model;

import javax.persistence.*;

@Entity
@Table(name = "hunter")
public class Hunter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hunter_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="level")
    private Integer level;

    @Column(name="busy")
    private Boolean busy;

    public Hunter() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Hunter(String name, Integer level, Boolean busy, String password) {
        this.name = name;
        this.level = level;
        this.busy = busy;
        this.password = password;

    }

    public Long getHunter_id() {
        return id;
    }

    public void setHunter_id(Long hunter_id) {
        this.id = hunter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }
}

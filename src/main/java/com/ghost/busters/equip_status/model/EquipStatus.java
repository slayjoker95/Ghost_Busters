package com.ghost.busters.equip_status.model;

import javax.persistence.*;

@Entity
@Table(name = "equip_status")
public class EquipStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_status_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public EquipStatus() {
    }

    public EquipStatus(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

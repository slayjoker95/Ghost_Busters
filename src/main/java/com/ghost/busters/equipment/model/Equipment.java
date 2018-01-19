package com.ghost.busters.equipment.model;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipment_id")
    private Long id;

    @Column(name = "level")
    private Integer level;

    public Long getEquipment_id() {
        return id;
    }

    public void setEquipment_id(Long equipment_id) {
        this.id = equipment_id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Equipment() {
    }

    public Equipment(Integer level) {
        this.level = level;
    }
}

package com.ghost.busters.o_status.model;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "o_status_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public OrderStatus() {
    }

    public OrderStatus(String name) {
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

package com.ghost.busters.prison.model;

import com.ghost.busters.order.model.Order;

import javax.persistence.*;

@Entity
@Table(name = "prison")
public class Prison {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prison_id")
    private Long prison_id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Prison() {
    }

    public Prison(Order order) {
        this.order = order;
    }

    public Long getPrison_id() {
        return prison_id;
    }

    public void setPrison_id(Long prison_id) {
        this.prison_id = prison_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

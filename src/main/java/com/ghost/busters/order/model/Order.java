package com.ghost.busters.order.model;

import com.ghost.busters.equip_status.model.EquipStatus;
import com.ghost.busters.hunter.model.Hunter;
import com.ghost.busters.o_status.model.OrderStatus;
import com.ghost.busters.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "z_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name="ghost_lvl")
    private Long ghost_lvl;

    @ManyToOne
    @JoinColumn(name="o_status_id")
    private OrderStatus orderStatus;

    @Column(name="adress")
    private String adress;

    @ManyToOne
    @JoinColumn(name="e_status_id")
    private EquipStatus equipStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="hunter_id")
    private Hunter hunter;

    public Order() {
    }

    public Order(String ghost_lvl, OrderStatus orderStatus, String adress, EquipStatus equipStatus, User user, Hunter hunter) {
        this.ghost_lvl = Long.valueOf(ghost_lvl);
        this.orderStatus = orderStatus;
        this.adress = adress;
        this.equipStatus = equipStatus;
        this.user = user;
        this.hunter = hunter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGhost_lvl() {
        return ghost_lvl;
    }

    public void setGhost_lvl(Long ghost_lvl) {
        this.ghost_lvl = ghost_lvl;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public EquipStatus getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(EquipStatus equipStatus) {
        this.equipStatus = equipStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public void setHunter(Hunter hunter) {
        this.hunter = hunter;
    }
}

package com.ghost.busters.order.model;

import com.ghost.busters.hunter.model.Hunter;
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

    @Column(name="status")
    private String status;

    @Column(name="adress")
    private String adress;

    @Column(name="equip_st")
    private String equip_st;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="hunter_id")
    private Hunter hunter;

    public Order() {
    }

    public Order(Long ghost_lvl, String status, String adress, String equip_st, User user, Hunter hunter) {
        this.ghost_lvl = ghost_lvl;
        this.status = status;
        this.adress = adress;
        this.equip_st = equip_st;
        this.user = user;
        this.hunter = hunter;
    }

    public Long getOrder_id() {
        return id;
    }

    public void setOrder_id(Long order_id) {
        this.id = order_id;
    }

    public Long getGhost_lvl() {
        return ghost_lvl;
    }

    public void setGhost_lvl(Long ghost_lvl) {
        this.ghost_lvl = ghost_lvl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEquip_st() {
        return equip_st;
    }

    public void setEquip_st(String equip_st) {
        this.equip_st = equip_st;
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

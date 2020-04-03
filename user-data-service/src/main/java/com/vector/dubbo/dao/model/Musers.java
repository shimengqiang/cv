package com.vector.dubbo.dao.model;

import java.util.Date;

public class Musers {
    private Long id;

    private String cardId;

    private Date creatAt;

    private Date lastUpdate;

    private String name;

    private String phone;

    public Musers(Long id, String cardId, Date creatAt, Date lastUpdate, String name, String phone) {
        this.id = id;
        this.cardId = cardId;
        this.creatAt = creatAt;
        this.lastUpdate = lastUpdate;
        this.name = name;
        this.phone = phone;
    }

    public Musers() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}
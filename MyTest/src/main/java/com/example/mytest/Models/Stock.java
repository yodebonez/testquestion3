package com.example.mytest.Models;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class Stock {

    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;

    public Stock(Long id, String name, BigDecimal currentPrice, Timestamp lastUpdate, Timestamp createDate) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdate = lastUpdate;
        this.createDate = createDate;
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

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

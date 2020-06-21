package com.smartzheng.luckymoney;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by smartzheng
 * 2020-06-21
 */
@Entity
public class Luckymoney {
    public Luckymoney() {
    }

    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal money;

    private String producer;

    private String consumer;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer == null ? "" : producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer == null ? "" : consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}

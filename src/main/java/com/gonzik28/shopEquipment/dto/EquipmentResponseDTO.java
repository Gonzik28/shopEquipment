package com.gonzik28.shopEquipment.dto;

import java.math.BigDecimal;

public abstract class EquipmentResponseDTO {

    Long id;
    Long serialNumber;
    String producer;
    BigDecimal price;
    int count;

    public Long getId() {
        return id;
    }
    public Long getSerialNumber() {
        return serialNumber;
    }

    public String getProducer() {
        return producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setCount(int count) {
        this.count = count;
    }
}

package com.gonzik28.shopEquipment.entity;

import jakarta.persistence.*;

@Entity
public class HDD extends Equipment{
    private Long capacity;

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}

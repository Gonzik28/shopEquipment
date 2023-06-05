package com.gonzik28.shopEquipment.entity;

import jakarta.persistence.*;

@Entity
public class Laptop extends Equipment{
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

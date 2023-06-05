package com.gonzik28.shopEquipment.entity;

import jakarta.persistence.*;

@Entity
public class Monitor extends Equipment{
    private int diagonal;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
}

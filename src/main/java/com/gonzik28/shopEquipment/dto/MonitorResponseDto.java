package com.gonzik28.shopEquipment.dto;

public class MonitorResponseDto extends EquipmentResponseDTO{
    private int diagonal;

    public MonitorResponseDto(){
        super();
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
}

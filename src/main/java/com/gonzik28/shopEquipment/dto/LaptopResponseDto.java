package com.gonzik28.shopEquipment.dto;

public class LaptopResponseDto extends EquipmentResponseDTO{
    private int size;

    public LaptopResponseDto(){
        super();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

package com.gonzik28.shopEquipment.dto;

public class HDDResponseDto extends EquipmentResponseDTO{
    private Long capacity;

    public HDDResponseDto(){
        super();
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}

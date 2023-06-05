package com.gonzik28.shopEquipment.dto;

import com.gonzik28.shopEquipment.entity.FormFactor;

public class DesktopComputerResponseDto extends EquipmentResponseDTO{
    private FormFactor formFactor;

    public DesktopComputerResponseDto(){
        super();
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}

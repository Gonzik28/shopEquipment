package com.gonzik28.shopEquipment.entity;

import jakarta.persistence.*;

@Entity
public class DesktopComputer extends Equipment{
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}

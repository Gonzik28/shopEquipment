package com.gonzik28.shopEquipment.dto.utils;

import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.dto.EquipmentResponseDTO;
import com.gonzik28.shopEquipment.entity.Equipment;


public interface EquipmentConverter <E extends Equipment, D extends EquipmentResponseDTO> {
    D convertEntityToDto(E equipment);
    E convertDtoToEntity(EquipmentRequestDTO dto);
}

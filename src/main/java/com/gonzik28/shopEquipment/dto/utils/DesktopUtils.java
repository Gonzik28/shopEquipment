package com.gonzik28.shopEquipment.dto.utils;

import com.gonzik28.shopEquipment.dto.DesktopComputerResponseDto;
import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.entity.DesktopComputer;


public class DesktopUtils implements EquipmentConverter<DesktopComputer,
        DesktopComputerResponseDto> {
    @Override
    public DesktopComputerResponseDto convertEntityToDto(DesktopComputer desktopComputer) {
        DesktopComputerResponseDto desktopComputerResponseDto = new DesktopComputerResponseDto();
        desktopComputerResponseDto.setId(desktopComputer.getId());
        desktopComputerResponseDto.setSerialNumber(desktopComputer.getSerialNumber());
        desktopComputerResponseDto.setProducer(desktopComputer.getProducer());
        desktopComputerResponseDto.setFormFactor(desktopComputer.getFormFactor());
        desktopComputerResponseDto.setCount(desktopComputer.getCount());
        desktopComputerResponseDto.setPrice(desktopComputer.getPrice());
        return desktopComputerResponseDto;
    }

    public DesktopComputer convertDtoToEntity(EquipmentRequestDTO equipmentRequestDTO) {
        DesktopComputer desktopComputer = new DesktopComputer();
        desktopComputer.setId(equipmentRequestDTO.getId());
        desktopComputer.setProducer(equipmentRequestDTO.getProducer());
        desktopComputer.setSerialNumber(equipmentRequestDTO.getSerialNumber());
        desktopComputer.setFormFactor(equipmentRequestDTO.getFormFactor());
        desktopComputer.setPrice(equipmentRequestDTO.getPrice());
        desktopComputer.setCount(equipmentRequestDTO.getCount());
        return desktopComputer;

    }

}

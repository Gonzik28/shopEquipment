package com.gonzik28.shopEquipment.dto.utils;

import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.dto.MonitorResponseDto;
import com.gonzik28.shopEquipment.entity.Monitor;

public class MonitorUtils implements EquipmentConverter<Monitor, MonitorResponseDto> {
    @Override
    public MonitorResponseDto convertEntityToDto(Monitor monitor) {
        MonitorResponseDto monitorResponseDto = new MonitorResponseDto();
        monitorResponseDto.setId(monitor.getId());
        monitorResponseDto.setSerialNumber(monitor.getSerialNumber());
        monitorResponseDto.setProducer(monitor.getProducer());
        monitorResponseDto.setDiagonal(monitor.getDiagonal());
        monitorResponseDto.setCount(monitor.getCount());
        monitorResponseDto.setPrice(monitor.getPrice());
        return monitorResponseDto;
    }

    @Override
    public Monitor convertDtoToEntity(EquipmentRequestDTO equipmentRequestDTO) {

        Monitor monitor = new Monitor();
        monitor.setId(equipmentRequestDTO.getId());
        monitor.setSerialNumber(equipmentRequestDTO.getSerialNumber());
        monitor.setProducer(equipmentRequestDTO.getProducer());
        monitor.setDiagonal(equipmentRequestDTO.getDiagonal());
        monitor.setCount(equipmentRequestDTO.getCount());
        monitor.setPrice(equipmentRequestDTO.getPrice());
        return monitor;
    }
}

package com.gonzik28.shopEquipment.dto.utils;

import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.dto.LaptopResponseDto;

import com.gonzik28.shopEquipment.entity.Laptop;

public class LaptopUtils implements EquipmentConverter<Laptop, LaptopResponseDto> {
    @Override
    public LaptopResponseDto convertEntityToDto(Laptop laptop) {
        LaptopResponseDto laptopResponseDto = new LaptopResponseDto();
        laptopResponseDto.setId(laptop.getId());
        laptopResponseDto.setSerialNumber(laptop.getSerialNumber());
        laptopResponseDto.setProducer(laptop.getProducer());
        laptopResponseDto.setSize(laptop.getSize());
        laptopResponseDto.setCount(laptop.getCount());
        laptopResponseDto.setPrice(laptop.getPrice());
        return laptopResponseDto;
    }

    @Override
    public Laptop convertDtoToEntity(EquipmentRequestDTO equipmentRequestDTO) {

        Laptop laptop = new Laptop();
        laptop.setId(equipmentRequestDTO.getId());
        laptop.setSerialNumber(equipmentRequestDTO.getSerialNumber());
        laptop.setProducer(equipmentRequestDTO.getProducer());
        laptop.setSize(equipmentRequestDTO.getSize());
        laptop.setCount(equipmentRequestDTO.getCount());
        laptop.setPrice(equipmentRequestDTO.getPrice());
        return laptop;

    }

}

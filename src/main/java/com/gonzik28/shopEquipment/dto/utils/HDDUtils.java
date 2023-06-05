package com.gonzik28.shopEquipment.dto.utils;

import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.dto.HDDResponseDto;
import com.gonzik28.shopEquipment.entity.HDD;

public class HDDUtils implements EquipmentConverter<HDD, HDDResponseDto> {
    @Override
    public HDDResponseDto convertEntityToDto(HDD hdd) {
        HDDResponseDto hddResponseDto = new HDDResponseDto();
        hddResponseDto.setId(hdd.getId());
        hddResponseDto.setSerialNumber(hdd.getSerialNumber());
        hddResponseDto.setProducer(hdd.getProducer());
        hddResponseDto.setCapacity(hdd.getCapacity());
        hddResponseDto.setCount(hdd.getCount());
        hddResponseDto.setPrice(hdd.getPrice());
        return hddResponseDto;
    }

    @Override
    public HDD convertDtoToEntity(EquipmentRequestDTO equipmentRequestDTO) {
        HDD hdd = new HDD();
        hdd.setId(equipmentRequestDTO.getId());
        hdd.setSerialNumber(equipmentRequestDTO.getSerialNumber());
        hdd.setProducer(equipmentRequestDTO.getProducer());
        hdd.setCapacity(equipmentRequestDTO.getCapacity());
        hdd.setCount(equipmentRequestDTO.getCount());
        hdd.setPrice(equipmentRequestDTO.getPrice());
        return hdd;

    }

}

package com.gonzik28.shopEquipment;

import com.gonzik28.shopEquipment.entity.Equipment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepository<T extends Equipment> extends CrudRepository<T, Long> {
    List<T> findAll();
}


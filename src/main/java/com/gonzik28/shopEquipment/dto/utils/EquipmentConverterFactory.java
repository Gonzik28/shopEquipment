package com.gonzik28.shopEquipment.dto.utils;


import java.util.HashMap;
import java.util.Map;

public class EquipmentConverterFactory {
    private static Map<String, EquipmentConverter<?, ?>> converterMap = new HashMap<>();

    public static void registerConverter(String equipmentClassName, EquipmentConverter<?, ?> converter) {
        converterMap.put(equipmentClassName, converter);
    }

    public static EquipmentConverter<?, ?> getConverter(String equipmentClassName) {
        return converterMap.get(equipmentClassName);
    }

    public static boolean isConverter(String equipmentClassName) {
        return converterMap.containsKey(equipmentClassName);
    }

}

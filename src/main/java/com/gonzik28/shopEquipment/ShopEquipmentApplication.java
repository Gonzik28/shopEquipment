package com.gonzik28.shopEquipment;

import com.gonzik28.shopEquipment.dto.utils.*;
import com.gonzik28.shopEquipment.entity.DesktopComputer;
import com.gonzik28.shopEquipment.entity.HDD;
import com.gonzik28.shopEquipment.entity.Laptop;
import com.gonzik28.shopEquipment.entity.Monitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopEquipmentApplication {
    static {
        EquipmentConverterFactory.registerConverter(DesktopComputer.class.getSimpleName(), new DesktopUtils());
        EquipmentConverterFactory.registerConverter(HDD.class.getSimpleName(), new HDDUtils());
        EquipmentConverterFactory.registerConverter(Laptop.class.getSimpleName(), new LaptopUtils());
        EquipmentConverterFactory.registerConverter(Monitor.class.getSimpleName(), new MonitorUtils());
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopEquipmentApplication.class, args);
    }

}

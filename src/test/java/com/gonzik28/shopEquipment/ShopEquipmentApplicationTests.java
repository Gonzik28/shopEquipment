package com.gonzik28.shopEquipment;


import com.gonzik28.shopEquipment.dto.DesktopComputerResponseDto;
import com.gonzik28.shopEquipment.dto.EquipmentResponseDTO;
import com.gonzik28.shopEquipment.dto.utils.DesktopUtils;
import com.gonzik28.shopEquipment.entity.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
@Transactional
class ShopEquipmentApplicationTests {
    @Spy
    @InjectMocks
    private EquipmentService equipmentService;
    @Mock
    private EquipmentRepository<Equipment> equipmentRepository;

    @Test
    public void findByIdTest() {
        DesktopComputer desktopComputer = new DesktopComputer();
        Long id = 1l;
        desktopComputer.setId(id);
        desktopComputer.setSerialNumber(123432345654l);
        desktopComputer.setProducer("Sony");
        desktopComputer.setFormFactor(FormFactor.моноблок);
        desktopComputer.setPrice(BigDecimal.valueOf(20000.00));
        desktopComputer.setCount(40);

        when(equipmentRepository.findById(any(Long.class))).thenReturn(Optional.of(desktopComputer));
        DesktopUtils desktopUtils = new DesktopUtils();
        DesktopComputerResponseDto desktopTest = desktopUtils.convertEntityToDto(desktopComputer);
        DesktopComputerResponseDto desktop = equipmentService.findById(desktopTest.getId());

        assertNotNull(desktopComputer);
        assertSame(desktopTest.getId(), desktop.getId());
        assertSame(desktopTest.getSerialNumber(), desktop.getSerialNumber());
        assertSame(desktopTest.getProducer(), desktop.getProducer());
        assertSame(desktopTest.getFormFactor(), desktop.getFormFactor());
    }

    @Test
    public <E extends Equipment, D extends EquipmentResponseDTO> void findByType() {
        String type = "DesktopComputer";
        List<D> equipmentList = new ArrayList<>();
        DesktopComputer desktopComputerOne = new DesktopComputer();
        desktopComputerOne.setId(1l);
        desktopComputerOne.setSerialNumber(123432345654l);
        desktopComputerOne.setProducer("Sony");
        desktopComputerOne.setFormFactor(FormFactor.моноблок);
        desktopComputerOne.setPrice(BigDecimal.valueOf(20000.00));
        desktopComputerOne.setCount(40);

        DesktopComputer desktopComputerTwo = new DesktopComputer();
        desktopComputerTwo.setId(2l);
        desktopComputerTwo.setSerialNumber(123432875651l);
        desktopComputerTwo.setProducer("Sony");
        desktopComputerTwo.setFormFactor(FormFactor.десктоп);
        desktopComputerTwo.setPrice(BigDecimal.valueOf(145000.00));
        desktopComputerTwo.setCount(20);

        DesktopUtils desktopUtils = new DesktopUtils();
        DesktopComputerResponseDto desktopTestOne = desktopUtils.convertEntityToDto(desktopComputerOne);
        DesktopComputerResponseDto desktopTestTwo = desktopUtils.convertEntityToDto(desktopComputerTwo);

        equipmentList.add((D) desktopTestOne);
        equipmentList.add((D) desktopTestTwo);

        doReturn(equipmentList).when(equipmentService).<E, D>findAllByType(any());

        List<D> response = equipmentService.<E, D>findAllByType(type);

        assertNotNull(response);
        assertEquals(2, response.size());

        D firstItem = response.get(0);
        assertNotNull(firstItem);
        assertTrue(firstItem instanceof DesktopComputerResponseDto);
        assertEquals(desktopTestOne.getId(), firstItem.getId());

        D secondItem = response.get(1);
        assertNotNull(secondItem);
        assertTrue(secondItem instanceof DesktopComputerResponseDto);
        assertEquals(desktopTestTwo.getId(), secondItem.getId());
    }

}
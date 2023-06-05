package com.gonzik28.shopEquipment;

import com.gonzik28.shopEquipment.dto.*;
import com.gonzik28.shopEquipment.dto.utils.*;
import com.gonzik28.shopEquipment.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Stream;


@Service
@Transactional
public class EquipmentService {
    private final EquipmentRepository<DesktopComputer> desktopComputerRepository;
    private final EquipmentRepository<HDD> hddRepository;
    private final EquipmentRepository<Laptop> laptopRepository;
    private final EquipmentRepository<Monitor> monitorRepository;


    public EquipmentService(EquipmentRepository<DesktopComputer> desktopComputerRepository,
                            EquipmentRepository<HDD> hddRepository,
                            EquipmentRepository<Laptop> laptopRepository,
                            EquipmentRepository<Monitor> monitorRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
        this.hddRepository = hddRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
    }

    public <E extends Equipment, D extends EquipmentResponseDTO> D findById(Long id) {
        Optional<? extends Equipment> equipmentOpt = Stream.of(
                        desktopComputerRepository.findById(id),
                        hddRepository.findById(id),
                        laptopRepository.findById(id),
                        monitorRepository.findById(id)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        if (equipmentOpt.isPresent()) {
            Equipment equipment = equipmentOpt.get();
            String equipmentClass = equipment.getClass().getSimpleName();
            EquipmentConverter<E, D> converter =
                    (EquipmentConverter<E, D>) EquipmentConverterFactory.getConverter(equipmentClass);
            return converter.convertEntityToDto((E) equipment);
        }
        return null;
    }

    public <E extends Equipment, D extends EquipmentResponseDTO> List<D> findAllByType(String type) {
        if (EquipmentConverterFactory.isConverter(type)) {
            List<E> resultList = (List<E>) desktopComputerRepository.findAll();
            List<D> dtoList = new ArrayList<>();
            EquipmentConverter<E, D> converter =
                    (EquipmentConverter<E, D>) EquipmentConverterFactory.getConverter(type);
            resultList.forEach(equipment->{
                if (equipment.getClass().getSimpleName().equals(type)) {
                    dtoList.add(converter.convertEntityToDto(equipment));
                }
            });
            return dtoList;
        }else{
            return null;
        }
    }

    public <E extends Equipment, D extends EquipmentResponseDTO> D create(EquipmentRequestDTO equipmentRequestDTO) {
        Map.Entry<String, EquipmentRepository> entry = findRepository(equipmentRequestDTO);
        if (entry != null) {
            String key = entry.getKey();
            EquipmentRepository value = entry.getValue();
            if (value.findById(equipmentRequestDTO.getId()).isPresent()) {
                return update(equipmentRequestDTO);
            } else {
                EquipmentConverter<E, D> converter =
                        (EquipmentConverter<E, D>) EquipmentConverterFactory.getConverter(key);
                return converter.convertEntityToDto((E) value.save(converter.convertDtoToEntity(equipmentRequestDTO)));
            }
        } else {
            return null;
        }
    }

    public <E extends Equipment, D extends EquipmentResponseDTO> D update(EquipmentRequestDTO equipmentRequestDTO) {
        Map.Entry<String, EquipmentRepository> entry = findRepository(equipmentRequestDTO);
        if (entry != null) {
            String key = entry.getKey();
            EquipmentRepository value = entry.getValue();
            if (value.findById(equipmentRequestDTO.getId()).isPresent()) {
                EquipmentConverter<E, D> converter = (EquipmentConverter<E, D>) EquipmentConverterFactory.getConverter(key);
                Equipment equipment = (Equipment) value.findById(equipmentRequestDTO.getId()).get();
                equipment.setProducer(equipmentRequestDTO.getProducer());
                equipment.setSerialNumber(equipmentRequestDTO.getSerialNumber());
                if (equipment instanceof DesktopComputer) {
                    DesktopComputer desktopComputer = (DesktopComputer) equipment;
                    desktopComputer.setFormFactor(equipmentRequestDTO.getFormFactor());
                } else if (equipment instanceof HDD) {
                    HDD hdd = (HDD) equipment;
                    hdd.setCapacity(equipmentRequestDTO.getCapacity());
                } else if (equipment instanceof Laptop) {
                    Laptop laptop = (Laptop) equipment;
                    laptop.setSize(equipmentRequestDTO.getSize());
                } else if (equipment instanceof Monitor) {
                    Monitor monitor = (Monitor) equipment;
                    monitor.setDiagonal(equipmentRequestDTO.getDiagonal());
                }
                equipment.setPrice(equipmentRequestDTO.getPrice());
                equipment.setCount(equipmentRequestDTO.getCount());
                equipment = (Equipment) value.save(equipment);
                return converter.convertEntityToDto((E) equipment);
            } else {
                return create(equipmentRequestDTO);
            }
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        desktopComputerRepository.deleteById(id);
    }

    public Map.Entry<String, EquipmentRepository> findRepository(EquipmentRequestDTO equipmentRequestDTO) {
        boolean isDiagonal = equipmentRequestDTO.getDiagonal() != null;
        boolean isSize = equipmentRequestDTO.getSize() != null;
        boolean isCapacity = equipmentRequestDTO.getCapacity() != null;
        boolean isFormFactor = equipmentRequestDTO.getFormFactor() != null;
        if (isFormFactor & !(isSize | isCapacity | isDiagonal)) {
            return new AbstractMap.SimpleEntry<>(DesktopComputer.class.getSimpleName(), desktopComputerRepository);
        }
        if (isCapacity & !(isSize | isFormFactor | isDiagonal)) {
            return new AbstractMap.SimpleEntry<>(HDD.class.getSimpleName(), hddRepository);
        }
        if (isSize & !(isCapacity | isFormFactor | isDiagonal)) {
            return new AbstractMap.SimpleEntry<>(Laptop.class.getSimpleName(), laptopRepository);
        }
        if (isDiagonal & !(isCapacity | isFormFactor | isSize)) {
            return new AbstractMap.SimpleEntry<>(Monitor.class.getSimpleName(), monitorRepository);
        }
        return null;
    }


}

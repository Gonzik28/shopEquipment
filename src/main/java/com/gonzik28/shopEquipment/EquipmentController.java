package com.gonzik28.shopEquipment;

import com.gonzik28.shopEquipment.dto.EquipmentRequestDTO;
import com.gonzik28.shopEquipment.dto.EquipmentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping(value = "/{id}")
    public <T extends EquipmentResponseDTO> ResponseEntity<T> findById(@PathVariable Long id) {
        if (equipmentService.findById(id) != null) {
            return ResponseEntity.ok(equipmentService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/type/{type}")
    public <T extends EquipmentResponseDTO> ResponseEntity<List<T>> findByType(@PathVariable String type) {
        if (equipmentService.findAllByType(type) != null) {
            if (equipmentService.findAllByType(type).size() != 0) {
                return ResponseEntity.ok(equipmentService.findAllByType(type));
            }
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/")
    public <T extends EquipmentResponseDTO> ResponseEntity<T> create(@RequestBody EquipmentRequestDTO requestRightDto) {
        T createdEquipment = equipmentService.create(requestRightDto);
        if (createdEquipment != null) {
            return ResponseEntity.ok(createdEquipment);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/update/")
    public <T extends EquipmentRequestDTO,
            R extends EquipmentResponseDTO> ResponseEntity<R> update(@RequestBody T requestRightDto) {
        R response = equipmentService.update(requestRightDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.gonzik28.shopEquipment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gonzik28.shopEquipment.entity.FormFactor;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipmentRequestDTO {
    private Long id;
    private Long serialNumber;
    private String producer;
    private BigDecimal price;
    private Integer count;
    private FormFactor formFactor;
    private Long capacity;
    private Integer size;
    private Integer diagonal;

    public EquipmentRequestDTO(Long id, Long serialNumber, String producer, BigDecimal price, Integer count,
                               FormFactor formFactor, Long capacity, Integer size, Integer diagonal) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.producer = producer;
        this.price = price;
        this.count = count;
        this.formFactor = formFactor;
        this.capacity = capacity;
        this.size = size;
        this.diagonal = diagonal;

        if (formFactor == null && capacity == null && size == null && diagonal == null) {
            throw new IllegalArgumentException("Необходимо заполнить хотя бы одно из необязательных полей");
        }
    }


    public Long getId() {
        return id;
    }
    public Long getSerialNumber() {
        return serialNumber;
    }
    public String getProducer() {
        return producer;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }
    public FormFactor getFormFactor() {
        return formFactor;
    }
    public Long getCapacity() {
        return capacity;
    }
    public Integer getSize() {
        return size;
    }
    public Integer getDiagonal() {
        return diagonal;
    }
}

package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane extends Vehicle {

    private String manufactured;
    @Column(name = "fuelcapacity")
    private int fuelCapacity;
    private int seats;

    public Airplane(Long id, String brand, String model, String manufactured, Short year, int fuelCapacity, int seats, Map<LocalDate, BigDecimal> estimations) {
        super(id, brand, model, year, estimations);
        this.manufactured = manufactured;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
    }
}

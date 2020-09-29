package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car extends Vehicle {

    private Double power;

    public Car(Long id, String brand, String model, Double power, Short year, Map<LocalDate, BigDecimal> estimations) {
        super(id, brand, model, year, estimations);
        this.power = power;
    }
}

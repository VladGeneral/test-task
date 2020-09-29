package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String brand;
    private String model;

    @Column(name = "year_of_issue")
    private Short year;

    @ElementCollection
    @CollectionTable(name = "costs")
    @MapKeyColumn(name = "values")
    @Column(name = "estimation")
    private Map<LocalDate, BigDecimal> estimations;
}

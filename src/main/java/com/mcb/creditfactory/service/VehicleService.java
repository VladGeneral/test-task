package com.mcb.creditfactory.service;

import java.util.Optional;

public interface VehicleService<Vehicle, VehicleDto> {
    boolean approve(VehicleDto dto);

    Vehicle save(Vehicle vehicle);

    Optional<Vehicle> load(Long id);

    Vehicle fromDto(VehicleDto dto);

    VehicleDto toDTO(Vehicle vehicle);

    Long getId(Vehicle vehicle);
}

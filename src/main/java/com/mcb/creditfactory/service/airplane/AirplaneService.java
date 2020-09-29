package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.service.VehicleService;

import java.util.Optional;

public interface AirplaneService extends VehicleService<Airplane, AirplaneDto> {
    @Override
    boolean approve(AirplaneDto airplaneDto);

    @Override
    Airplane save(Airplane airplane);

    @Override
    Optional<Airplane> load(Long id);

    @Override
    Airplane fromDto(AirplaneDto airplaneDto);

    @Override
    AirplaneDto toDTO(Airplane airplane);

    @Override
    Long getId(Airplane airplane);
}

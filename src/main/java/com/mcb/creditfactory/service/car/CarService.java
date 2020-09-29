package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.VehicleService;

import java.util.Optional;

public interface CarService extends VehicleService<Car, CarDto> {

    @Override
    boolean approve(CarDto carDto);

    @Override
    Car save(Car car);

    @Override
    Optional<Car> load(Long id);

    @Override
    Car fromDto(CarDto carDto);

    @Override
    CarDto toDTO(Car car);

    @Override
    Long getId(Car car);
}

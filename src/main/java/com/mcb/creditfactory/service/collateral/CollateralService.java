package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;

    @Autowired
    private AirplaneService airplaneService;


    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }
            return saveOptional(car);

        } else if (object instanceof AirplaneDto) {
            AirplaneDto airplane = (AirplaneDto) object;
            boolean approved = airplaneService.approve(airplane);
            if (!approved) {
                return null;
            }
            return saveOptional(airplane);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Collateral getInfo(Collateral object) {
        if (object instanceof CarDto) {
            return getOptional(object);
        } else if (object instanceof AirplaneDto) {
            return getOptional(object);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Long saveOptional(Collateral col) {
        if (col instanceof CarDto) {
            return Optional.of((CarDto) col)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);
        } else {
            return Optional.of((AirplaneDto) col)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::save)
                    .map(airplaneService::getId)
                    .orElse(null);
        }
    }

    private Collateral getOptional(Collateral col) {
        if (col instanceof CarDto) {
            return Optional.of((CarDto) col)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        } else {
            return Optional.of((AirplaneDto) col)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::getId)
                    .flatMap(airplaneService::load)
                    .map(airplaneService::toDTO)
                    .orElse(null);
        }
    }
}

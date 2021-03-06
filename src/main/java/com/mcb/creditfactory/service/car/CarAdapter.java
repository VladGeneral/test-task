package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.service.collateral.CollateralAdapter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
public class CarAdapter extends CollateralAdapter {
    private CarDto car;

    @Override
    protected Map<LocalDate, BigDecimal> doGetEstimate() {
        return car.getEstimations();
    }

    @Override
    protected Short doGetYear() {
        return car.getYear();
    }

    @Override
    protected CollateralType doGetType() {
        return CollateralType.CAR;
    }
}

package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.service.collateral.CollateralAdapter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
public class AirplaneAdapter extends CollateralAdapter {
    private AirplaneDto airplaneDto;

    @Override
    protected Map<LocalDate, BigDecimal> doGetEstimate() {
        return airplaneDto.getEstimations();
    }

    @Override
    protected Short doGetYear() {
        return airplaneDto.getYear();
    }

    @Override
    protected CollateralType doGetType() {
        return CollateralType.AIRPLANE;
    }
}

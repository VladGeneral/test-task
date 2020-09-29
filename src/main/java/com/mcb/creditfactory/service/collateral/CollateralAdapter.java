package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
public abstract class CollateralAdapter implements CollateralObject {

    protected abstract Map<LocalDate, BigDecimal> doGetEstimate();

    protected abstract Short doGetYear();

    protected abstract CollateralType doGetType();

    private Map<LocalDate, BigDecimal> getEstimate() {
        return doGetEstimate();
    }

    @Override
    public BigDecimal getValue() {
        Map<LocalDate, BigDecimal> estimate = getEstimate();
        return (BigDecimal) estimate.values().toArray()[estimate.size() - 1];
    }

    @Override
    public Short getYear() {
        return doGetYear();
    }

    @Override
    public LocalDate getDate() {
        Map<LocalDate, BigDecimal> estimate = getEstimate();
        return (LocalDate) estimate.keySet().toArray()[estimate.size() - 1];
    }

    @Override
    public CollateralType getType() {
        return doGetType();
    }
}

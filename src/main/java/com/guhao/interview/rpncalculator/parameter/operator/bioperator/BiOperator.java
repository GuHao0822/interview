package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.storager.Storager;

/**
 * BiOperator
 * @author guhao
 */
public abstract class BiOperator implements Parameter {
    @Override
    public void apply(Storager storager) {
        if (validateOperation(storager)) {
            calculate(storager);
        }
    }

    abstract void calculate(Storager storager);

    protected History getOperationHistory(BigDecimal first, BigDecimal second) {
        List<BigDecimal> params = Arrays.asList(second, first);
        return new History(params, this);
    }

    protected boolean validateOperation(Storager storager) {
        if (storager.getSize() < NumberConstants.TWO) {
            throw new IllegalArgumentException(ErrorConstants.NEED_TWO_PARAMETERS);
        }
        return true;
    }
}
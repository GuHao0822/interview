/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.parameter.operator.unaryoperator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.storager.Storager;

/**
 * UnaryOperator
 * @author guhao
 */
public abstract class UnaryOperator implements Parameter {
    @Override
    public void apply(Storager storager) {
        if (validateOperation(storager)) {
            calculate(storager);
        }
    }

    abstract void calculate(Storager storager);

    protected History getOperationRecord(BigDecimal digit) {
        List<BigDecimal> params = Arrays.asList(digit);
        return new History(params, this);
    }

    protected boolean validateOperation(Storager storager) {
        if (storager.getSize() < NumberConstants.ONE) {
            throw new IllegalArgumentException(ErrorConstants.NEED_ONE_PARAMETER);
        }
        return true;
    }
}
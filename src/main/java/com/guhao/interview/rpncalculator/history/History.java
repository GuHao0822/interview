/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.history;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.parameter.Parameter;

/**
 * Record operation for Operator UNDO
 * @author guhao
 */
public class History {
    /** digits list */
    private List<BigDecimal> digits;
    /** operator */
    private Parameter        operator;

    /**
     * @return List<BigDecimal>
     */
    public List<BigDecimal> getDigits() {
        return digits;
    }

    /**
     * @return Operator
     */
    public Parameter getOperator() {
        return operator;
    }

    /**
     * @param parameters
     */
    public History(List<BigDecimal> parameters) {
        if (CollectionUtils.isEmpty(parameters)) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_CANNOT_BE_NULL);
        }
        this.digits = parameters;
    }

    /**
     * @param parameters
     * @param operator
     */
    public History(List<BigDecimal> parameters, Parameter operator) {
        this(parameters);
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "History{" +
                "digits=" + digits +
                ", operator=" + operator +
                '}';
    }
}
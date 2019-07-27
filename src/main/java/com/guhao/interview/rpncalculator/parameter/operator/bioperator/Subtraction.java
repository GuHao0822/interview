/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * Subtraction -
 * @author guhao
 */
public class Subtraction extends BiOperator{
    @Override
    void calculate(Storager storager) {
        BigDecimal subtrahend = storager.popDigit();
        BigDecimal minuend = storager.popDigit();
        BigDecimal result = minuend.subtract(subtrahend).setScale(NumberConstants.FIFTEEN,BigDecimal.ROUND_HALF_UP);
        storager.pushDigit(result);

        History history = getOperationHistory(subtrahend, minuend);
        storager.pushHistory(history);
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.SUBTRACTION.getSymbol(), counter);
    }

    @Override
    public String get() {
        return OperatorEnum.SUBTRACTION.getSymbol();
    }
}
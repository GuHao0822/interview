/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.parameter.operator.customoperator;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * UNDO
 * Cancel the last operation
 * @author guhao
 */
public class Undo implements Parameter {
    @Override
    public void apply(Storager storager) {
        History history = storager.popHistory();
        Parameter operator = history.getOperator();
        if (!(operator instanceof Clear)) {
            storager.popDigit();
        }
        if (null != history.getOperator()) {
            for (BigDecimal digit : history.getDigits()) {
                storager.pushDigit(digit);
            }
        }
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.UNDO.getSymbol(), counter);
    }

    @Override
    public String get() {
        return OperatorEnum.UNDO.getSymbol();
    }
}
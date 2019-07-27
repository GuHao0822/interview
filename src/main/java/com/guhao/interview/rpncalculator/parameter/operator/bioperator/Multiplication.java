package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * Multiplication *
 * @author guhao
 */
public class Multiplication extends BiOperator {
    @Override
    void calculate(Storager storager) {
        BigDecimal multiplier = storager.popDigit();
        BigDecimal multiplicand = storager.popDigit();
        BigDecimal result = multiplicand.multiply(multiplier).setScale(NumberConstants.FIFTEEN, BigDecimal.ROUND_HALF_UP);
        storager.pushDigit(result);

        History history = getOperationHistory(multiplier, multiplicand);
        storager.pushHistory(history);
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.MULTIPLICATION.getSymbol(), counter);
    }

    @Override
    public String get() {
        return OperatorEnum.MULTIPLICATION.getSymbol();
    }
}
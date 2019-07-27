package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * Division /
 * @author guhao
 */
public class Division extends BiOperator {
    @Override
    void calculate(Storager storager) {
        BigDecimal divisor = storager.popDigit();

        if (BigDecimal.ZERO.equals(divisor)) {
            storager.pushDigit(divisor);
            System.err.println(ErrorConstants.DIVISOR_IS_ZERO);
            return;
        }

        BigDecimal dividend = storager.popDigit();
        BigDecimal result = dividend.divide(divisor, NumberConstants.FIFTEEN, BigDecimal.ROUND_HALF_UP);
        storager.pushDigit(result);

        History history = getOperationHistory(divisor, dividend);
        storager.pushHistory(history);
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.DIVISION.getSymbol(), counter);
    }

    @Override
    public String get() {
        return OperatorEnum.DIVISION.getSymbol();
    }
}
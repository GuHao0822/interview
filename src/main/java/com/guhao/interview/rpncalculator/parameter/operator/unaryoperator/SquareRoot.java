package com.guhao.interview.rpncalculator.parameter.operator.unaryoperator;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * SquareRoot
 * @author guhao
 */
public class SquareRoot extends UnaryOperator {
    @Override
    void calculate(Storager storager) {
        BigDecimal digit = storager.popDigit();
        if (digit.intValue() >= NumberConstants.ZERO) {
            BigDecimal result = new BigDecimal(Math.sqrt(digit.doubleValue())).setScale(NumberConstants.FIFTEEN,
                    BigDecimal.ROUND_HALF_UP);
            storager.pushDigit(result);
            History history = this.getOperationRecord(digit);
            storager.pushHistory(history);
        } else {
            storager.pushDigit(digit);
            System.err.println(ErrorConstants.CANNOT_BE_SQUARE);
        }
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.SQUAREROOT.getSymbol(), counter);
    }

    @Override
    public String get() {
        return OperatorEnum.SQUAREROOT.getSymbol();
    }
}
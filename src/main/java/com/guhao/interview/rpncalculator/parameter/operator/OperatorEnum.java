package com.guhao.interview.rpncalculator.parameter.operator;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;

/**
 * OperatorEnum
 * @author guhao
 */
public enum OperatorEnum {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    SQUAREROOT("sqrt"),
    UNDO("undo"),
    CLEAR("clear");

    private String symbol;

    OperatorEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static OperatorEnum getOperator(String parameter) {
        for(OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getSymbol().equalsIgnoreCase(parameter)) {
                return operator;
            }
        }
        throw new IllegalArgumentException(ErrorConstants.OPERATOR_IS_UNDEFINED);
    }
}
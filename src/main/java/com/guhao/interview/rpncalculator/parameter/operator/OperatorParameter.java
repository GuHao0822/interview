/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.parameter.operator;

import java.util.Optional;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Addition;
import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Division;
import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Multiplication;
import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Subtraction;
import com.guhao.interview.rpncalculator.parameter.operator.customoperator.Clear;
import com.guhao.interview.rpncalculator.parameter.operator.customoperator.Undo;
import com.guhao.interview.rpncalculator.parameter.operator.unaryoperator.SquareRoot;

/**
 * OperatorParameter
 * @author guhao
 */
public class OperatorParameter {
    public static Optional<Parameter> getOperator(final String userEntered) {
        Optional<Parameter> result = Optional.empty();

        OperatorEnum operator = OperatorEnum.getOperator(userEntered);
        switch (operator) {
            case ADDITION:
                result = Optional.of(new Addition());
                break;
            case SUBTRACTION:
                result = Optional.of(new Subtraction());
                break;
            case MULTIPLICATION:
                result = Optional.of(new Multiplication());
                break;
            case DIVISION:
                result = Optional.of(new Division());
                break;
            case SQUAREROOT:
                result = Optional.of(new SquareRoot());
                break;
            case CLEAR:
                result = Optional.of(new Clear());
                break;
            case UNDO:
                result = Optional.of(new Undo());
                break;
            default:
                throw new IllegalArgumentException(ErrorConstants.OPERATOR_IS_UNDEFINED);
        }
        return result;
    }
}
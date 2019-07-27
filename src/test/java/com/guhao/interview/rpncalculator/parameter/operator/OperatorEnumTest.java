package com.guhao.interview.rpncalculator.parameter.operator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xihe.gh
 * @version : OperatorEnumTest.java, v 0.1 2019-07-27 15:01 xihe.gh Exp $$
 */
public class OperatorEnumTest {

    @Test
    public void getSymbol() {
        assertEquals("sqrt", OperatorEnum.SQUAREROOT.getSymbol());
        assertEquals("+", OperatorEnum.ADDITION.getSymbol());
        assertEquals("-", OperatorEnum.SUBTRACTION.getSymbol());
        assertEquals("*", OperatorEnum.MULTIPLICATION.getSymbol());
        assertEquals("/", OperatorEnum.DIVISION.getSymbol());
        assertEquals("undo", OperatorEnum.UNDO.getSymbol());
        assertEquals("clear", OperatorEnum.CLEAR.getSymbol());
    }

    @Test
    public void getOperator() {
       assertEquals(OperatorEnum.ADDITION, OperatorEnum.getOperator("+"));
       assertEquals(OperatorEnum.SUBTRACTION, OperatorEnum.getOperator("-"));
       assertEquals(OperatorEnum.MULTIPLICATION, OperatorEnum.getOperator("*"));
       assertEquals(OperatorEnum.DIVISION, OperatorEnum.getOperator("/"));
       assertEquals(OperatorEnum.SQUAREROOT, OperatorEnum.getOperator("sqrt"));
       assertEquals(OperatorEnum.UNDO, OperatorEnum.getOperator("undo"));
       assertEquals(OperatorEnum.CLEAR, OperatorEnum.getOperator("clear"));
    }
}
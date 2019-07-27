package com.guhao.interview.rpncalculator.parameter.operator;

import org.junit.Assert;
import org.junit.Test;

public class OperatorParameterTest {

    @Test
    public void getOperator() {
       Assert.assertEquals("+", OperatorParameter.getOperator("+").get().get());
       Assert.assertEquals("-", OperatorParameter.getOperator("-").get().get());
       Assert.assertEquals("/", OperatorParameter.getOperator("/").get().get());
       Assert.assertEquals("*", OperatorParameter.getOperator("*").get().get());
       Assert.assertEquals("clear", OperatorParameter.getOperator("clear").get().get());
       Assert.assertEquals("undo", OperatorParameter.getOperator("undo").get().get());
       Assert.assertEquals("sqrt", OperatorParameter.getOperator("sqrt").get().get());
    }
}
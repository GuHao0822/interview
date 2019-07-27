package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class MultiplicationTest {
    private Storager storager;
    private Multiplication multiplication;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        multiplication = new Multiplication();
    }
    @Test
    public void calculate() {
        storager.pushDigit(new BigDecimal(11L));
        storager.pushDigit(new BigDecimal(2L));
        multiplication.calculate(storager);
        Assert.assertEquals("22", storager.popDigit().stripTrailingZeros().toPlainString());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = multiplication.getErrorMessage(1);
        Assert.assertEquals("Operator: * (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = multiplication.get();
        Assert.assertEquals("*",symbol);
    }
}
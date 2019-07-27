package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class SubtractionTest {

    private Storager    storager;
    private Subtraction subtraction;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        subtraction = new Subtraction();
    }

    @Test
    public void calculate() {
        storager.pushDigit(new BigDecimal(11L));
        storager.pushDigit(new BigDecimal(2L));
        subtraction.calculate(storager);
        Assert.assertEquals("9", storager.popDigit().stripTrailingZeros().toPlainString());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = subtraction.getErrorMessage(1);
        Assert.assertEquals("Operator: - (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = subtraction.get();
        Assert.assertEquals("-", symbol);
    }
}
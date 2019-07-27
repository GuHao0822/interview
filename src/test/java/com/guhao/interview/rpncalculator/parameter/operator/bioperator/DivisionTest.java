package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class DivisionTest {
    private Storager storager;
    private Division division;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        division = new Division();
    }

    @Test
    public void calculate() {
        storager.pushDigit(new BigDecimal(11L));
        storager.pushDigit(new BigDecimal(2L));
        division.calculate(storager);
        Assert.assertEquals("5.5", storager.popDigit().stripTrailingZeros().toPlainString());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = division.getErrorMessage(1);
        Assert.assertEquals("Operator: / (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = division.get();
        Assert.assertEquals("/",symbol);
    }
}
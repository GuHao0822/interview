package com.guhao.interview.rpncalculator.parameter.operator.unaryoperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class SquareRootTest {

    private Storager    storager;
    private SquareRoot squareRoot;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        squareRoot = new SquareRoot();
    }

    @Test
    public void apply() {
        storager.pushDigit(new BigDecimal(11L));
        squareRoot.apply(storager);
        Assert.assertEquals("3.3166247903554", storager.popDigit().stripTrailingZeros().toPlainString());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = squareRoot.getErrorMessage(1);
        Assert.assertEquals("Operator: sqrt (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = squareRoot.get();
        Assert.assertEquals("sqrt", symbol);
    }
}
package com.guhao.interview.rpncalculator.calculator;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class RpnCalculatorTest {

    @Test(expected = NoSuchElementException.class)
    public void calculate() {
        String data = "1 2 3 4 5 *";
        RpnCalculator rpnCalculator = new RpnCalculator(new ByteArrayInputStream(data.getBytes()));
        rpnCalculator.calculate();
        Assert.assertEquals(6, rpnCalculator.getStorager().getSize().intValue());
    }

}
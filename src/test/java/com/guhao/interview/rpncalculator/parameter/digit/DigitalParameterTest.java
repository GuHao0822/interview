package com.guhao.interview.rpncalculator.parameter.digit;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class DigitalParameterTest {
    private Storager storager;
    private DigitalParameter digitalParameter;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        digitalParameter = new DigitalParameter("5");
    }

    @Test
    public void apply() {
        digitalParameter.apply(storager);
        Assert.assertEquals(new BigDecimal(5),storager.popDigit());
        Assert.assertEquals(new BigDecimal(5),storager.popHistory().getDigits().get(0));
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = digitalParameter.getErrorMessage(1);
        Assert.assertEquals("Operator: 5 (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        Assert.assertEquals("5", digitalParameter.get());
    }
}
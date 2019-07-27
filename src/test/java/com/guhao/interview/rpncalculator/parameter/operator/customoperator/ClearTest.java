package com.guhao.interview.rpncalculator.parameter.operator.customoperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

public class ClearTest {

    private Storager storager;
    private Clear    clear;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        clear = new Clear();
    }

    @Test
    public void apply() {
        storager.pushDigit(new BigDecimal(11L));
        storager.pushDigit(new BigDecimal(2L));
        clear.apply(storager);
        Assert.assertEquals(0L, storager.getSize().intValue());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = clear.getErrorMessage(1);
        Assert.assertEquals("Operator: clear (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = clear.get();
        Assert.assertEquals("clear", symbol);
    }
}
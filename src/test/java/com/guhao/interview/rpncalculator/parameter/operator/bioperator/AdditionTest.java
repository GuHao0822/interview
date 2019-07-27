package com.guhao.interview.rpncalculator.parameter.operator.bioperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdditionTest {
    private Storager storager;
    private Addition addition;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        addition = new Addition();
    }

    @Test
    public void testApply() {
        storager.pushDigit(new BigDecimal(5));
        storager.pushDigit(new BigDecimal(6));
        addition.calculate(storager);
        BigDecimal result = storager.popDigit();
        Assert.assertEquals(11L, result.longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongParameter(){
        addition.apply(storager);
    }

    @Test
    public void testGetErrorMessage() {
        String errorMessage = addition.getErrorMessage(1);
        Assert.assertEquals("Operator: + (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = addition.get();
        Assert.assertEquals("+", symbol);
    }
}
package com.guhao.interview.rpncalculator.history;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Addition;
import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

import static org.junit.Assert.*;

public class HistoryTest {
    private Storager storager;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
    }

    @Test
    public void getBiOperatorHistory() {
        storager.pushDigit(new BigDecimal(5L));
        storager.pushDigit(new BigDecimal(2L));
        Addition addition = new Addition();
        addition.apply(storager);

        History history = storager.popHistory();
        Assert.assertEquals("+", history.getOperator().get());
        assertEquals(new BigDecimal(5L),history.getDigits().get(0));
        assertEquals(new BigDecimal(2L),history.getDigits().get(1));
    }

    @Test
    public void getOperator() {
    }
}
package com.guhao.interview.rpncalculator.parameter.operator.customoperator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.guhao.interview.rpncalculator.parameter.operator.bioperator.Addition;
import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

/**
 * @author xihe.gh
 * @version : UndoTest.java, v 0.1 2019-07-27 14:41 xihe.gh Exp $$
 */
public class UndoTest {

    private Storager storager;
    private Undo     undo;
    private Addition addition;

    @Before
    public void before() {
        storager = new RpnStorager();
        storager.init();
        addition = new Addition();
        undo = new Undo();
    }

    @Test
    public void apply() {
        storager.pushDigit(new BigDecimal(11L));
        storager.pushDigit(new BigDecimal(2L));
        addition.apply(storager);
        undo.apply(storager);
        Assert.assertEquals(2L, storager.popDigit().longValue());
        Assert.assertEquals(11L, storager.popDigit().longValue());
    }

    @Test
    public void getErrorMessage() {
        String errorMessage = undo.getErrorMessage(1);
        Assert.assertEquals("Operator: undo (position: 1): insucient parameters", errorMessage);
    }

    @Test
    public void get() {
        String symbol = undo.get();
        Assert.assertEquals("undo", symbol);
    }
}
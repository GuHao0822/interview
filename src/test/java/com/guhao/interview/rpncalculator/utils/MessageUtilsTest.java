package com.guhao.interview.rpncalculator.utils;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xihe.gh
 * @version : MessageUtilsTest.java, v 0.1 2019-07-27 15:35 xihe.gh Exp $$
 */
public class MessageUtilsTest {
    @Test
    public void formatTenScale() {
        String s = MessageUtils.formatTenScale(new BigDecimal("2.10000"));
        Assert.assertEquals(s, "2.1");
        s = MessageUtils.formatTenScale(new BigDecimal("1.341518181818111"));
        Assert.assertEquals(s,"1.3415181818");
        s = MessageUtils.formatTenScale(new BigDecimal("1"));
        Assert.assertEquals(s,"1");
    }
}
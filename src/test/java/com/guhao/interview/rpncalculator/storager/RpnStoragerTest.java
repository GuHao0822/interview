package com.guhao.interview.rpncalculator.storager;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author xihe.gh
 * @version : RpnStoragerTest.java, v 0.1 2019-07-27 16:00 xihe.gh Exp $$
 */
public class RpnStoragerTest {

    @Test
    public void print() {
       Storager storager = new RpnStorager();
       storager.init();
       storager.pushDigit(BigDecimal.ZERO);
       storager.pushDigit(BigDecimal.TEN);
       storager.print();
    }
}
package com.guhao.interview.rpncalculator.storager;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.history.History;

/**
 * Calulator's Storager
 * @author guhao
 */
public interface Storager {
    /**
     * init Storager inner data structure
     */
    void init();

    /**
     * push digit parameter
     * @param digit
     */
    void pushDigit(BigDecimal digit);

    /**
     * pop digit parameter
     * @return Bigdecimal
     */
    BigDecimal popDigit();

    /**
     * push operation record
     * @param history
     */
    void pushHistory(History history);

    /**
     * pop operation history
     * @return History
     * @see  History
     */
    History popHistory();

    /**
     * @return size of parameter
     */
    Integer getSize();

    /**
     * print parameter
     */
    void print();
}
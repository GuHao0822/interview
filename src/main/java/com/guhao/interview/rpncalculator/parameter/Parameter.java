/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.parameter;

import com.guhao.interview.rpncalculator.storager.Storager;

/**
 * Parameter
 * @author guhao
 */
public interface Parameter {
    /**
     * @param storager
     */
    void apply(Storager storager);

    /**
     * @param counter
     * @return errorMessage
     */
    String getErrorMessage(int counter);

    /**
     * @return String of parameter
     */
    String get();
}
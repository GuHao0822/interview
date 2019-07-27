/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.calculator;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guhao.interview.rpncalculator.constants.ErrorConstants;
import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.constants.SymbolConstants;
import com.guhao.interview.rpncalculator.input.CommandLineInput;
import com.guhao.interview.rpncalculator.input.Input;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.storager.RpnStorager;
import com.guhao.interview.rpncalculator.storager.Storager;

/**
 * calulaor with RPN(reverse polish notation) mode
 * @author guhao
 */
public class RpnCalculator {
    private static final Logger logger = LoggerFactory.getLogger(RpnCalculator.class);

    private Input    input;
    private Storager storager;

    private static final String BEGINNING = "(The parameter ";
    private static final String ENDING = "were not pushed on to the stack due to the previous error)";

    public RpnCalculator() {
        this(System.in);
    }

    public RpnCalculator(InputStream in) {
        if (null == in) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_CANNOT_BE_NULL);
        }
        this.input = new CommandLineInput(in);
        this.storager = new RpnStorager();
        storager.init();
    }

    public void calculate() {
        List<Parameter> parameters = null;
        AtomicInteger counter = new AtomicInteger(NumberConstants.ONE);
        while( null != (parameters = input.getInput())) {
            for(Parameter parameter : parameters) {
                try {
                    parameter.apply(storager);
                    counter.incrementAndGet();
                } catch (IllegalArgumentException ex) {
                    logger.error("#RpnCalculator#calculate#IllegalArgumentException#", ex);
                    System.err.println(parameter.getErrorMessage(counter.get()));
                    break;
                } catch (Exception ex) {
                    logger.error("#RpnCalculator#calculate#Exception#", ex);
                    break;
                }
            }
            storager.print();
            if (counter.get() < parameters.size()) {
                System.err.println(printNotPushedParameters(counter, parameters));
            }
            counter.set(NumberConstants.ONE);
        }
    }

    private String printNotPushedParameters(AtomicInteger counter, List<Parameter> parameters) {
        StringBuilder message = new StringBuilder();
        message.append(BEGINNING);
        for (int i = counter.get(); i < parameters.size(); i++) {
            message.append(parameters.get(i).get());
            message.append(SymbolConstants.SPACE);
        }
        message.append(ENDING);
        return message.toString();
    }

    /**
     * Getter method for property <tt>storager</tt>.
     *
     * @return property value of storager
     */
    public Storager getStorager() {
        return storager;
    }
}
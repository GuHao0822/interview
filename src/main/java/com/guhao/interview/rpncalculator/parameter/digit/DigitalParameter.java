package com.guhao.interview.rpncalculator.parameter.digit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * Digital Parameter 0 1 2 3 4 5 6 7 8 9 0
 * @author guhao
 */
public class DigitalParameter implements Parameter {
    private final BigDecimal digit;

    public DigitalParameter(final String digit) {
        this.digit = new BigDecimal(digit);
    }

    @Override
    public void apply(Storager storager) {
        storager.pushDigit(digit);
        storager.pushHistory(constrcutHistory());
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(digit.toPlainString(), counter);
    }

    @Override
    public String get() {
        return digit.toPlainString();
    }

    private History constrcutHistory() {
        List<BigDecimal> digits = new ArrayList<>();
        digits.add(digit);
        History history = new History(digits);
        return history;
    }
}
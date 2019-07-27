package com.guhao.interview.rpncalculator.storager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.guhao.interview.rpncalculator.constants.SymbolConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * RpnStorager
 * @author guhao
 */
public class RpnStorager implements Storager {
    private static final String HEADING = "Stack: ";

    private Stack<BigDecimal> digitStack;
    private Stack<History>    history;

    @Override
    public void init() {
        digitStack = new Stack<>();
        history = new Stack<>();
    }

    @Override
    public void pushDigit(BigDecimal digit) {
        digitStack.push(digit);
    }

    @Override
    public BigDecimal popDigit() {
        return digitStack.pop();
    }

    @Override
    public void pushHistory(History history) {
        this.history.push(history);
    }

    @Override
    public History popHistory() {
        return history.pop();
    }

    @Override
    public Integer getSize() {
        return digitStack.size();
    }

    @Override
    public void print() {
        System.out.print(HEADING);
        List<BigDecimal> elements = new ArrayList<>(this.digitStack);
        elements.forEach(e -> {
            String result = MessageUtils.formatTenScale(e.stripTrailingZeros());
            System.out.print(result);
            System.out.print(SymbolConstants.SPACE);
        });
        System.out.println();
    }

    @Override
    public String toString() {
        return "RpnStorager{" +
                "digitStack=" + digitStack +
                ", history=" + history +
                '}';
    }
}
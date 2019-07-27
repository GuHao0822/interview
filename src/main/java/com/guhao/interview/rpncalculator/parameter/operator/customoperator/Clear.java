package com.guhao.interview.rpncalculator.parameter.operator.customoperator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.util.CollectionUtils;

import com.guhao.interview.rpncalculator.constants.NumberConstants;
import com.guhao.interview.rpncalculator.history.History;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorEnum;
import com.guhao.interview.rpncalculator.storager.Storager;
import com.guhao.interview.rpncalculator.utils.MessageUtils;

/**
 * clear all parameters in stack
 * @author guhao
 */
public class Clear implements Parameter {
    @Override
    public void apply(Storager storager) {
        List<BigDecimal> elements = new ArrayList<>();
        while (storager.getSize() != NumberConstants.ZERO) {
            elements.add(storager.popDigit());
        }
        if (getOperationRecord(elements).isPresent()) {
            storager.pushHistory(getOperationRecord(elements).get());
        }
    }

    @Override
    public String getErrorMessage(int counter) {
        return MessageUtils.getErrorMessage(OperatorEnum.CLEAR.getSymbol(), counter);
    }

    private Optional<History> getOperationRecord(List<BigDecimal> elements) {
        if (CollectionUtils.isEmpty(elements)) {
            return Optional.empty();
        }
        List<BigDecimal> reverseList = new ArrayList<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            reverseList.add(elements.get(i));
        }

        return Optional.of(new History(reverseList, this));
    }

    @Override
    public String get() {
        return OperatorEnum.CLEAR.getSymbol();
    }
}
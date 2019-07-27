package com.guhao.interview.rpncalculator.utils;

import java.math.BigDecimal;

import com.guhao.interview.rpncalculator.constants.NumberConstants;

/**
 * MessageUtils
 *
 * @author guhao
 */
public class MessageUtils {
    public static final String ERROR_MESSAGE_HEADING   = "Operator: ";
    public static final String ERROR_MESSAGE_BEGINNING = " (position: ";
    public static final String ERROR_MESSAFE_ENDING    = "): insucient parameters";

    public static String getErrorMessage(String symbol, Integer counter) {
        StringBuilder message = new StringBuilder(ERROR_MESSAGE_HEADING);
        message.append(symbol);
        message.append(ERROR_MESSAGE_BEGINNING);
        message.append(counter);
        message.append(ERROR_MESSAFE_ENDING);
        return message.toString();
    }

    public static String formatTenScale(BigDecimal digit) {
        return digit.setScale(NumberConstants.TEN, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
    }
}
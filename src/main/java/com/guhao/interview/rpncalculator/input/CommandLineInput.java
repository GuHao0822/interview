/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.guhao.interview.rpncalculator.input;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.util.StringUtils;

import com.guhao.interview.rpncalculator.constants.SymbolConstants;
import com.guhao.interview.rpncalculator.parameter.Parameter;
import com.guhao.interview.rpncalculator.parameter.digit.DigitalParameter;
import com.guhao.interview.rpncalculator.parameter.operator.OperatorParameter;

/**
 * get user input from command line
 * @author guhao
 */
public class CommandLineInput implements Input{
    private final Scanner scanner;

    public CommandLineInput(InputStream in) {
        this.scanner = new Scanner(in);
    }

    @Override
    public List<Parameter> getInput() {
        List<Parameter> result = new ArrayList<>();
        String parameterStr = scanner.nextLine();

        if (StringUtils.isEmpty(parameterStr)) {
            return result;
        }

        String[] parameters = parameterStr.split(SymbolConstants.SPACE);
        for (String parameter : parameters) {
            Optional<Parameter> userEntry = this.constructParameter(parameter);
            if (userEntry.isPresent()) {
                result.add(userEntry.get());
            }
        }

        return result;
    }

    private Optional<Parameter> constructParameter(String parameter) {
        Optional<Parameter> result = Optional.empty();

        if (StringUtils.isEmpty(parameter)) {
            return result;
        }

        if (parameter.matches(SymbolConstants.REGEX_DIGIT_PATTERN)) {
            result =  Optional.of(new DigitalParameter(parameter));
        }
        else {
            result = getOperatorParameter(parameter);
        }
        return result;
    }

    private Optional<Parameter> getOperatorParameter(String parameter) {
        Optional<Parameter> optionalParameter = Optional.empty();
        try {
            optionalParameter = OperatorParameter.getOperator(parameter);
        } catch (IllegalArgumentException ex) {
            System.err.println(parameter + " is not defined");
        }
        return optionalParameter;
    }

}
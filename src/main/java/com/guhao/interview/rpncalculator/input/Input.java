package com.guhao.interview.rpncalculator.input;

import java.util.List;

import com.guhao.interview.rpncalculator.parameter.Parameter;

/**
 * Handle user input from different way
 * @author guhao
 */
public interface Input {
    /**
     * get user input
     * @return List<Parameter>
     */
    List<Parameter> getInput();
}
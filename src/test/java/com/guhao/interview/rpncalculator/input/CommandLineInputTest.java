package com.guhao.interview.rpncalculator.input;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.guhao.interview.rpncalculator.parameter.Parameter;

public class CommandLineInputTest {

    @Test
    public void getInput() {
        String data = "1 2 3 4 5 *";
        CommandLineInput commandLineInput = new CommandLineInput(new ByteArrayInputStream(data.getBytes()));
        List<Parameter> input = commandLineInput.getInput();
        Assert.assertEquals("3", input.get(2).get());
        Assert.assertEquals("*", input.get(5).get());
    }
}
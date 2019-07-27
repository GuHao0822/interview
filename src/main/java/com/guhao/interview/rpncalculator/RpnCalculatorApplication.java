package com.guhao.interview.rpncalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guhao.interview.rpncalculator.calculator.RpnCalculator;

@SpringBootApplication
public class RpnCalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(RpnCalculatorApplication.class, args);
		new RpnCalculator().calculate();
	}
}

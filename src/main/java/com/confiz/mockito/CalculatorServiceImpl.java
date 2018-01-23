package com.confiz.mockito;

import java.util.concurrent.TimeUnit;

public class CalculatorServiceImpl implements CalculatorService{

	public double add(double input1, double input2) {

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			
		}
		return input1+input2;
	}

	public double subtract(double input1, double input2) {
		// TODO Auto-generated method stub
		return input1-input2;
	}

	public double multiply(double input1, double input2) {
		// TODO Auto-generated method stub
		return input1*input2;
	}

	public double divide(double input1, double input2) {
		// TODO Auto-generated method stub
		return input1/input2;
	}

}

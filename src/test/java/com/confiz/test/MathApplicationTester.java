package com.confiz.test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.codahale.metrics.Timer;
import com.confiz.mockito.CalculatorService;
import com.confiz.mockito.CalculatorServiceImpl;
import com.confiz.mockito.MathApplication;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	Timer timer = new Timer();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@Test
	public void testAdd() {

		double expected = 30.00;

		when(calcService.add(10.0, 20.0)).thenReturn(expected);
		
		Timer.Context addContext = timer.time();
		double result = mathApplication.add(10.0, 20.0);
		System.out.println("Execution Time with mocking: " + addContext.stop());
		
		// test the add functionality
		Assert.assertEquals(expected, result, 0);

		// verify the behavior
		verify(calcService).add(10.0, 20.0);
	}

	@Test
	public void testRealAdd() {

		double expected = 30.00;

		MathApplication mathReal = new MathApplication();
		CalculatorService calcServiceReal = new CalculatorServiceImpl();
		mathReal.setCalculatorService(calcServiceReal);

		Timer.Context addContext = timer.time();
		double result = mathReal.add(10.0, 20.0);
		System.out.println("Execution Time without mocking: " + addContext.stop());
		Assert.assertEquals(expected, result, 0);

	}

	@Test
	public void testSub() {
		// add the behavior of calc service to sub two numbers
		when(calcService.subtract(30.0, 20.0)).thenReturn(10.00);

		// test the subtract functionality
		Assert.assertEquals(mathApplication.subtract(30.0, 20.0), 10.0, 0);
	}

	@Test
	public void testMul() {
		// add the behavior of calc service to mul two numbers
		when(calcService.multiply(10.0, 20.0)).thenReturn(200.00);

		// test the multiply functionality
		Assert.assertEquals(mathApplication.multiply(10.0, 20.0), 200.0, 0);
	}

	// @Test
	// public void testDiv() {
	// // add the behavior of calc service to div two numbers
	// when(calcService.divide(30.0, 5.0)).thenReturn(6.00);
	//
	// // test the divide functionality
	// Assert.assertEquals(mathApplication.divide(30.0, 5.0), 6.0, 0);
	// }
}
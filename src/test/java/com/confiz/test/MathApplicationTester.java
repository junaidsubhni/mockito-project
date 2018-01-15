package com.confiz.test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.confiz.mockito.CalculatorService;
import com.confiz.mockito.MathApplication;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      
      //verify the behavior
      verify(calcService).add(10.0, 20.0);
   }
   
   @Test
   public void testSub(){
      //add the behavior of calc service to add two numbers
      when(calcService.subtract(30.0,20.0)).thenReturn(10.00);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.subtract(30.0, 20.0),10.0,0);
   }
   
   @Test
   public void testMul(){
      //add the behavior of calc service to add two numbers
      when(calcService.multiply(10.0,20.0)).thenReturn(200.00);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.multiply(10.0, 20.0),200.0,0);
   }
   
   @Test
   public void testDiv(){
      //add the behavior of calc service to add two numbers
      when(calcService.divide(30.0,5.0)).thenReturn(6.00);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.divide(30.0, 5.0),6.0,0);
   }
}
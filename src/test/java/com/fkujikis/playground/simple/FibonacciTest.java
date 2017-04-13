package com.fkujikis.playground.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	Fibonacci f = new Fibonacci();
	
	@Test
	public void testCalculateFibonacciNumber() {
		assertEquals(0, f.calculateNthFibonacciNumber(0));
		assertEquals(1, f.calculateNthFibonacciNumber(1));
		assertEquals(1, f.calculateNthFibonacciNumber(2));
		assertEquals(2, f.calculateNthFibonacciNumber(3));
		assertEquals(3, f.calculateNthFibonacciNumber(4));
		assertEquals(5, f.calculateNthFibonacciNumber(5));
		assertEquals(8, f.calculateNthFibonacciNumber(6));
		assertEquals(1134903170L, f.calculateNthFibonacciNumber(45));
	}
	
	@Test
	public void testCalculateFibonacciNumberIterative() {
		assertEquals(0, f.calculateNthFibonacciNumberIterative(0));
		assertEquals(1, f.calculateNthFibonacciNumberIterative(1));
		assertEquals(1, f.calculateNthFibonacciNumberIterative(2));
		assertEquals(2, f.calculateNthFibonacciNumberIterative(3));
		assertEquals(3, f.calculateNthFibonacciNumberIterative(4));
		assertEquals(5, f.calculateNthFibonacciNumberIterative(5));
		assertEquals(8, f.calculateNthFibonacciNumberIterative(6));
		assertEquals(1134903170L, f.calculateNthFibonacciNumberIterative(45));
	}
}

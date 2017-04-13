package com.fkujikis.playground.simple;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class FactorialTest {

	private Factorial f = new Factorial();
	
	@Test
	public void testCalculateFactorial() {
		assertEquals(1, f.calculateFactorial(0));
		assertEquals(1, f.calculateFactorial(1));
		assertEquals(2, f.calculateFactorial(2));
		assertEquals(6, f.calculateFactorial(3));
		assertEquals(120, f.calculateFactorial(5));
		assertEquals(3628800, f.calculateFactorial(10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculateFactorialNegative(){
		f.calculateFactorial(-1);
	}
	
	@Test
	public void testCalculateFactorialIterative() {
		assertEquals(1, f.calculateFactorialIteratively(0));
		assertEquals(1, f.calculateFactorialIteratively(1));
		assertEquals(2, f.calculateFactorialIteratively(2));
		assertEquals(6, f.calculateFactorialIteratively(3));
		assertEquals(120, f.calculateFactorialIteratively(5));
		assertEquals(3628800, f.calculateFactorialIteratively(10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculateFactorialIterativeNegative(){
		f.calculateFactorialIteratively(-1);
	}
	
	@Test
	public void testCalculateFactorialBigInteger(){
		assertEquals(new BigInteger("1"), f.calculateBigFactorial(new BigInteger("0")));
		assertEquals(new BigInteger("1"), f.calculateBigFactorial(new BigInteger("1")));
		assertEquals(new BigInteger("3628800"), f.calculateBigFactorial(new BigInteger("10")));
		assertEquals(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), f.calculateBigFactorial(new BigInteger("50")));
		assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), f.calculateBigFactorial(new BigInteger("100")));
	}
	
	@Test(expected=StackOverflowError.class)
	public void testCalculateFactorialBigIntegerStackLimit(){
		f.calculateBigFactorial(new BigInteger("10000"));
	}
	
	@Test
	public void testCalculateFactorialBigIntegerIterative(){
		assertEquals(new BigInteger("1"), f.calculateBigFactorialIteratively(new BigInteger("0")));
		assertEquals(new BigInteger("1"), f.calculateBigFactorialIteratively(new BigInteger("1")));
		assertEquals(new BigInteger("3628800"), f.calculateBigFactorialIteratively(new BigInteger("10")));
		assertEquals(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), f.calculateBigFactorialIteratively(new BigInteger("50")));
		assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), f.calculateBigFactorialIteratively(new BigInteger("100")));
	}
	
	@Test
	public void testCalculateFactorialBigIntegerIterativeNoStackOverflow(){
		f.calculateBigFactorialIteratively(new BigInteger("10000"));
	}

}

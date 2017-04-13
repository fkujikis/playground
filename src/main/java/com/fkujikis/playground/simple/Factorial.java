package com.fkujikis.playground.simple;

import java.math.BigInteger;

public class Factorial {
	
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	
	public long calculateFactorial(long n){	
		if(n < 0)
			throw new IllegalArgumentException("Can not calculate factorial for a negative number. Input was : " + n);
		
		if(n == 0)
			return 1;
		else
			return n * calculateFactorial(n-1);
	}
	
	public long calculateFactorialIteratively(long n){
		if(n < 0)
			throw new IllegalArgumentException("Can not calculate factorial for a negative number. Input was : " + n);
		
		long result = 1;
		
		while(n > 1){
			result = result * n;
			n--;
		}
		
		return result;
	}

	public BigInteger calculateBigFactorial(BigInteger n){
		if(n.compareTo(ZERO) < 0)
			throw new IllegalArgumentException("Can not calculate factorial for a negative number. Input was : " + n);
		
		if(n.equals(ZERO))
			return ONE;
		else
			return n.multiply(calculateBigFactorial(n.subtract(ONE)));
	}
	
	public BigInteger calculateBigFactorialIteratively(BigInteger n){
		if(n.compareTo(ZERO) < 0)
			throw new IllegalArgumentException("Can not calculate factorial for a negative number. Input was : " + n);
		
		BigInteger result = new BigInteger("1");
		
		while(n.compareTo(ONE) > 0){
			result = result.multiply(n);
			n = n.subtract(ONE);
		}
		
		return result;
	}
}

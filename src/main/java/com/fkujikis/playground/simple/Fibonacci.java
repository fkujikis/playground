package com.fkujikis.playground.simple;


public class Fibonacci {

	// A number is found by getting the sum of the two numbers before it
	public long calculateNthFibonacciNumber(long n){
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return calculateNthFibonacciNumber(n-1) + calculateNthFibonacciNumber(n-2); 
	}
	
	public long calculateNthFibonacciNumberIterative(long n){
		
		if(n < 2)
			return n;
		
		long result = n;
		long fibNMinus1 = 1;
		long fibNMinus2 = 0;

		for(long count = 2; count <= n; count++){
			// The result is the sum
			result = fibNMinus1 + fibNMinus2;
			
			// Current (n-1) becomes (n-2) on the next iteration
			fibNMinus2 = fibNMinus1;
			// Current result becomes (n-1) on the next iteration
			fibNMinus1 = result;
		}
		
		return result;
	}
	
}

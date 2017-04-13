package com.fkujikis.playground.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimesTest {

	private Primes p = new Primes();
	
	@Test
	public void testPrime() {
		assertEquals(true, p.isPrimeNaive(2));
//		assertEquals(true, p.isPrime(7));
//		assertEquals(true, p.isPrime(17));
//		assertEquals(true, p.isPrime(29));
//		assertEquals(true, p.isPrime(37));
//		
//		
//		assertEquals(false, p.isPrime(1));
//		assertEquals(false, p.isPrime(4));
//		assertEquals(false, p.isPrime(10));
//		assertEquals(false, p.isPrime(35));
//		assertEquals(false, p.isPrime(99));
	}
	
	@Test
	public void testFirstNPrimes(){
		assertArrayEquals(new Object[]{2L, 3L, 5L, 7L, 11L}, p.findFirstNPrimesNaive(5).toArray());
	}
	
	@Test
	public void testRunTimeNaive(){
		System.out.println("First 5000 primes found: " + p.findFirstNPrimesNaive(5000));
	}
	
	@Test
	public void testRunTimeHalfDivisors(){
		System.out.println("First 5000 primes found: " + p.findFirstNPrimesImproved(5000));
	}
	
	@Test
	public void testRunTimeBest(){
		System.out.println("First 5000 primes found: " + p.findFirstNPrimesBest(5000));
	}

	@Test
	public void testAllPrimesUpToN(){
		System.out.println("Primes less than 100: " + p.findAllPrimesLessThan(100));
	}
	
	@Test
	public void testAllPrimesUpToNUsingSieve(){
		System.out.println("Primes less than 100: " + p.findAllPrimesUsinSieve(100));
	}
}

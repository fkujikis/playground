package com.fkujikis.playground.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

	
	
	public boolean isPrimeNaive(long n){
		
		if(n == 1) return false;
		
		long divisor = 2;
		
		// Check all divisors up to the size of the number
		while(divisor < n){
			if(n % divisor == 0){
				return false;
			} else {
				divisor++;
			}
		}
		
		return true;
	}
	
	public boolean isPrimeImproved(long n){
		
		if(n == 1) return false;
		
		long divisor = 2;
		
		// The largest divisor yielding non-0 remainder will never be more than half
		while(divisor <= (n+1)/2){
			if(n % divisor == 0){
				return false;
			} else {
				divisor++;
			}
		}
		
		return true;
	}
	
	public boolean isPrimeBest(long n){
		
		if(n == 1) return false;
		
		// We observe that all primes are odd except for 2.
		// Therefore anything divisible by 2 and greater than 2 is non-prime.
		if(n > 2 && n % 2 == 0)
			return false;
		
		// Check divisible by odd numbers
		long divisor = 3;
		
		// If n has a factor larger than divisor, it also has a factor smaller than it
		// If we find either of them we've proven the number is non prime already
		while(divisor * divisor <= n ){
			if(n % divisor == 0){
				return false;
			} else {
				divisor+=2;
			}
		}
		
		return true;
	}
	
	public List<Long> findFirstNPrimesNaive(long n){
		
		List<Long> primes = new ArrayList<Long>();
		
		long integer = 1;
		long primeCount = 0;
		
		while(primeCount < n){
			if(isPrimeNaive(integer)){
				primes.add(integer);
				primeCount++;
			}
			integer++;
		}
		
		return primes;
		
	}
	
	public List<Long> findFirstNPrimesImproved(long n){
		List<Long> primes = new ArrayList<Long>();
		
		long integer = 1;
		long primeCount = 0;
		
		while(primeCount < n){
			if(isPrimeImproved(integer)){
				primes.add(integer);
				primeCount++;
			}
			integer++;
		}
		
		return primes;
	}
	
	public List<Long> findFirstNPrimesBest(long n){
		List<Long> primes = new ArrayList<Long>();
		
		long integer = 1;
		long primeCount = 0;
		
		while(primeCount < n){
			if(isPrimeBest(integer)){
				primes.add(integer);
				primeCount++;
			}
			integer++;
		}
		
		return primes;
	}
	
	public List<Integer> findAllPrimesLessThan(int n){
		
		int[] primes = new int[n];
		
		
		// Non primes marked with 1
		primes[0] = 1;
		primes[1] = 1;
		
		// Find next unmarked
		
		// Check if it's prime
		
		// Mark it and all multiples
		
		for(int i = 2; i < n; i++){
			
			if(primes[i] == 1){
				 // skip
				continue;
			} else {
				// check if it's prime
				if(isPrimeBest(i)){
					// mark all multiples until the end as non-prime
					for(int j = i+i; j < n; j=j+i){
						primes[j] = 1;
					}
				}
			}
		}
		
		List<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			if(primes[i] != 1){
				results.add(i);
			}
		}
		
		return results;
	}
	
	public List<Integer> findAllPrimesUsinSieve(int limit){
		
		// Mark 0 and 1 as nonprime
		// Start assuming everything >= 2 is prime - mark all as primes
		// Go through all numbers, starting at 2
		// If a number is marked as prime, mark all its multiples as nonprime
		// Ignore numbers marked as nonprime and iterate though all numbers
		// For every number marked prime repeat the same
		// When finished only primes will be marked
		
		boolean[] primes = new boolean[limit+1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i <= limit; i++){
			if(primes[i]){
				// Mark all multiples as non-prime
				for(int j = 2 * i; j <= limit; j+=i){
					primes[j] = false;
				}
			}
		}
		
		List<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i <= limit; i++){
			if(primes[i]){
				results.add(i);
			}
		}
		
		return results;
	}
}

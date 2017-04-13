package com.fkujikis.playground.puzzles;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.junit.Test;

public class SimulateRand7UsingRand5Test {

	@Test
	public void testDistributionOfRand7() {
		SimulateRand7UsingRand5 rand = new SimulateRand7UsingRand5();
		int numCalls = 1000000;
		double maxNumber = 7;
		// 0.5% error margin
		double tolerance = 0.005;
		double expectedCount = numCalls / maxNumber;
		double countMax = expectedCount * (1 + tolerance);
		double countMin = expectedCount * (1 - tolerance);
		
		Map<Integer, Integer> histogram = testRandomDistribution(numCalls, rand::rand7);
		
		System.out.println("Expected occurrences of each integer: " + expectedCount);
		System.out.println("Tolerance %: " + tolerance * 100);
		
		for(Integer key : histogram.keySet()){
			int count = histogram.get(key);
			
			System.out.println(key + " : " + count);
			assertEquals(true, count < countMax && count > countMin);
		}
	}
	
	private Map<Integer, Integer> testRandomDistribution(int numCalls, Supplier<Integer> randMethod){
		// A map storing the number of occurrences of each random result
		Map<Integer, Integer> resultsCount = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < numCalls; i++){
			Integer random = randMethod.get();
			Integer currentCount = resultsCount.putIfAbsent(random, 1);
			
			if(currentCount != null){
				resultsCount.put(random, currentCount + 1);
			}
		}
	
		return resultsCount;
	}
	
}

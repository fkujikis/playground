package com.fkujikis.playground.puzzles;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.junit.Test;

public class SimulateRand5UsingRand7Test {

	
	private SimulateRand5UsingRand7 rand = new SimulateRand5UsingRand7();
	
	@Test
	public void testDistributionOfRand5() {
		
		int numCalls = 30;
		
		Map<Integer, Integer> histogram = testRandomDistribution(numCalls, rand::rand5);
		
		for(Integer key : histogram.keySet()){
			int count = histogram.get(key);
			System.out.println(key + " : " + count);
			
			// As long as numCalls is a multiple of 5, we will have an even distribution
			assertEquals(numCalls/5, count);
		}
	}
	
	@Test
	public void testDistributionOfRand7() {
		
		int numCalls = 28;
		
		Map<Integer, Integer> histogram = testRandomDistribution(numCalls, rand::rand7);
		
		for(Integer key : histogram.keySet()){
			int count = histogram.get(key);
			System.out.println(key + " : " + count);
			
			// As long as numCalls is a multiple of 7, we will have an even distribution
			assertEquals(numCalls/7, count);
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

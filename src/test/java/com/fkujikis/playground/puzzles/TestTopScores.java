package com.fkujikis.playground.puzzles;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestTopScores {

	
	private TopScores ts = new TopScores();
	
	int[] unsorted_scores = {37, 89, 41, 65, 91, 53};
	int[] sorted = {37, 41, 53, 65, 89, 91};
	int HIGHEST_POSSIBLE_SCORE = 100000;
	
	int[] largeArray;
	
	@Before
	public void init(){
		largeArray = generateRandomArray(100000, HIGHEST_POSSIBLE_SCORE);
	}
	
	@Test
	public void testScores() {
		assertArrayEquals(sorted, ts.sortScores(unsorted_scores, HIGHEST_POSSIBLE_SCORE));
	}
	
	@Test
	public void testScoresNLogN() {
		assertArrayEquals(sorted, ts.sortScoresNLogN(unsorted_scores));
	}
	
	@Test
	public void testLargeSortsCorrect(){
		assertArrayEquals(ts.sortScores(largeArray, HIGHEST_POSSIBLE_SCORE),ts.sortScoresNLogN(largeArray));
	}
	
	@Test
	public void testSort1(){
		ts.sortScores(largeArray, HIGHEST_POSSIBLE_SCORE);
	}
	
	@Test
	public void testSort1NlogN(){
		ts.sortScoresNLogN(largeArray);
	}
	
	private int[] generateRandomArray(int n, int maxValue){
	    int[] list = new int[n];
	    Random random = new Random();

	    for (int i = 0; i < n; i++)
	    {
	        list[i] = random.nextInt(maxValue);
	    }
	    
	   return list;
	}
}

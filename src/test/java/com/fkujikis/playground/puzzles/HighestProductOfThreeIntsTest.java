package com.fkujikis.playground.puzzles;

import static org.junit.Assert.*;

import org.junit.Test;

public class HighestProductOfThreeIntsTest {

	private HighestProductOfThreeInts hpt = new HighestProductOfThreeInts();
	
	private int[] in1 = {1, 2, 3};
	private int ex1 = 6;
	
	private int[] in2 = {1, 2, 3, 4};
	private int ex2 = 24;
	
	private int[] in3 = {4, 2, -3, -4};
	private int ex3 = 48;	
	
	private int[] in4 = {1, 10, -5, 1, -100};
	private int ex4 = 5000;
	
	
	@Test
	public void testCalculateHighestProductBruteForce() {
		assertEquals(ex1, hpt.calculateHighestProductBruteForce(in1));
		assertEquals(ex2, hpt.calculateHighestProductBruteForce(in2));
		assertEquals(ex3, hpt.calculateHighestProductBruteForce(in3));	
		assertEquals(ex4, hpt.calculateHighestProductBruteForce(in4));	
	}
	
	@Test
	public void testCalculateHighestProductNaive() {
		assertEquals(ex1, hpt.calculateHighestProductNaive(in1));
		assertEquals(ex2, hpt.calculateHighestProductNaive(in2));
		// Fail : can't handle negatives
		//assertEquals(ex3, hpt.calculateHighestProductNaive(in3));		
	}
	
	@Test
	public void testCalculateHighestProductBest() {
		assertEquals(ex1, hpt.calculateHighestProductBest(in1));
		assertEquals(ex2, hpt.calculateHighestProductBest(in2));
		assertEquals(ex3, hpt.calculateHighestProductBest(in3));
		assertEquals(ex4, hpt.calculateHighestProductBest(in4));
	}

}

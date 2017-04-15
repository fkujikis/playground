package com.fkujikis.playground.puzzles;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestProductOfOtherNumbers {

	private ProductOfOtherNumbers p = new ProductOfOtherNumbers();
	
	@Test
	public void tesProduct() {
		int[] in1 = {1, 7, 3, 4};
		int[] expected1 = {84, 12, 28, 21};
		assertArrayEquals(expected1, p.calculateProducts(in1));
		
		int[] in2 = {0, 7, 3, 4};
		int[] expected2 = {84, 0, 0, 0};
		assertArrayEquals(expected2, p.calculateProducts(in2));
	}
	
	@Test
	public void tesProductGreedy() {
		int[] in1 = {1, 7, 3, 4};
		int[] expected1 = {84, 12, 28, 21};
		assertArrayEquals(expected1, p.calculateProductsGreedy(in1));
		
		int[] in2 = {0, 7, 3, 4};
		int[] expected2 = {84, 0, 0, 0};
		assertArrayEquals(expected2, p.calculateProductsGreedy(in2));
	}
	
	@Test
	public void tesProductBest() {
		int[] in1 = {1, 7, 3, 4};
		int[] expected1 = {84, 12, 28, 21};
		assertArrayEquals(expected1, p.calculateProductsBest(in1));
		
		int[] in2 = {0, 7, 3, 4};
		int[] expected2 = {84, 0, 0, 0};
		assertArrayEquals(expected2, p.calculateProductsBest(in2));
	}
	
	@Test
	public void testLargeStandard(){
		int[] large = generateRandomArray(10000,10);
		p.calculateProducts(large);
	}
	
	@Test
	public void testLargeGreedy(){
		int[] large = generateRandomArray(10000,10);
		p.calculateProductsGreedy(large);
	}
	
	@Test
	public void testLargeArray(){
		int[] large = generateRandomArray(1000,10);
		
		assertArrayEquals(p.calculateProducts(large),p.calculateProductsGreedy(large));
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

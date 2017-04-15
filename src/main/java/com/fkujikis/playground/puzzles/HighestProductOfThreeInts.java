package com.fkujikis.playground.puzzles;

import java.util.Arrays;

//Given an array of integers, find the highest product you can get from three of the integers.
//The input arrayOfInts will always have at least three integers.

public class HighestProductOfThreeInts {

	// Approach:
	
	// Find the 3 largest ints
	
	// Multiply them
	
	// (sort the array and last 3) - but won't work for negatives
	
	public int calculateHighestProductBruteForce(int[] arr){
		int maxProduct = 0;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){

				if(j == i) continue;

				for(int k = 0; k < arr.length; k++){
					
					if(k == i || k == j) continue;
					
					int product = arr[i] * arr[j] * arr[k];
					maxProduct = Math.max(maxProduct, product);
				}
			}
		}
		
		return maxProduct;
	}
	
	public int calculateHighestProductNaive(int[] arrayOfInts){
		// Problems:
		
		// N log N to sort
		
		// Does not work for negative numbers in the mix
		
		int len = arrayOfInts.length;
		
		Arrays.sort(arrayOfInts);

		return arrayOfInts[len-1] * arrayOfInts[len-2] * arrayOfInts[len-3];
	}
	
	public int calculateHighestProductBest(int[] array){
		
		// We want a single pass through the array
		
		// Track the two most negative and two most positive numbers
		
		int maxProduct = 0;
		int negative1 = 0;
		int negative2 = 0;
		int positive1 = 0;
		int positive2 = 0;
		
		for(int i = 0; i < array.length; i++){
			
			int current = array[i];
			
			// We can't calculate without 3 numbers
			if(i > 1) { 		
				int highestProduct = 0;
				// If negative
				if(current < 0){
					// The most negative * the most positive * current
					highestProduct = negative1 * positive1 * current;
				} else {
					int p1 = positive1 * positive2 * current;
					int p2 = negative1 * negative2 * current;
					highestProduct = Math.max(p1, p2);
				}
				
				maxProduct = Math.max(maxProduct, highestProduct);
			}
			
			// Update
			if(current < negative1){
				negative2 = negative1;
				negative1 = current;
			} else if(current < negative2){
				negative2 = current;
			}
			
			if(current > positive1){
				positive2 = positive1;
				positive1 = current;
			} else if(current > positive2){
				positive2 = current;
			}
		}
		
		return maxProduct;
	}
	
}

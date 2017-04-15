package com.fkujikis.playground.puzzles;

public class ProductOfOtherNumbers {

	public int[] calculateProducts(int[] input){
		
		int[] products = new int[input.length];
		
		for(int i = 0; i < input.length; i++){
			int product = 1;
			for(int j = 0; j < input.length; j++){
				if(i == j){
					continue;
				}
				product = product * input[j];
			}
			products[i] = product;
		}

		return products;
	}
	
	public int[] calculateProductsGreedy(int[] input){
		
		// This uses 3 arrays 3 x O(n) space
		// We could reduce it to single array by building up the result in a single array
		// We will need multiple passes to finish the results
		
		int[] products = new int[input.length];
		int[] productsBeforeIndex = new int[input.length];
		productsBeforeIndex[0] = 1;
		int[] productsAfterIndex = new int[input.length];
		productsAfterIndex[input.length-1] = 1;
		
		for(int i = 1; i < input.length; i++){
			productsBeforeIndex[i] = productsBeforeIndex[i-1] * input[i-1];
		}
		
		for(int i = input.length-2; i >= 0; i--){
			productsAfterIndex[i] = productsAfterIndex[i+1] * input[i+1];
		}
		
		for(int i = 0; i < input.length; i++){
			products[i] = productsBeforeIndex[i] * productsAfterIndex[i];
		}

		return products;
	}
	
	public int[] calculateProductsBest(int[] input){
		
		// Same solution as above, just uses less memory
		
		if(input.length <2) throw new IllegalArgumentException();
		
		int[] products = new int[input.length];
		products[0] = 1;
		products[input.length-1] = 1;
		
		// Build up products before index
		for(int i = 1; i < input.length; i++){
			products[i] = products[i-1] * input[i-1];
		}
		
		// Multiply in products after index
		int productAfterIndex = 1;
		for(int i = input.length-1; i >= 0; i--){
			products[i] = products[i] * productAfterIndex;
			productAfterIndex = productAfterIndex * input[i];
		}
		
		return products;
	}
	
}

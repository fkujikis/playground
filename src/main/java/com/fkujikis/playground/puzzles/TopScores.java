package com.fkujikis.playground.puzzles;

import java.util.Arrays;

public class TopScores {

	// Need sorting faster than O(n log n)
	
	// We define n as the size of the array
	
	public int[] sortScores(int[] unsortedScores, int highestScore){
		
		// Keep a count for each value, since highest score is low (100)
		// we can just use an array of that size.
		int[] valueCounts = new int[highestScore+1];

		// Update the count at each array index
		for(int i = 0; i < unsortedScores.length; i++){
			int index = unsortedScores[i];
			valueCounts[index] = valueCounts[index] + 1;
		}
		
		int[] results = new int[unsortedScores.length];
		int resultsIndex = 0;
		
		// Populate the results : for each index containing a count, insert the index count times
		for(int i = 0; i < valueCounts.length; i++){
			if(valueCounts[i] != 0){
				for(int j = 0; j < valueCounts[i]; j++){
					results[resultsIndex] = i;
					resultsIndex++;
				}
			}
		}
		
		return results;
	}
	
	public int[] sortScoresNLogN(int[] unsortedScores){
		
		int[] sorted = Arrays.stream(unsortedScores).sorted().toArray();

		return sorted;
	}
	
}

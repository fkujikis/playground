package com.fkujikis.playground.puzzles;

import java.util.concurrent.ThreadLocalRandom;

public class SimulateRand7UsingRand5 {
	
	/**
	 * We need to expand the range 1-5 to 1-7.
	 * 
	 * Both must return each integer with equal probability.
	 * 
	 * rand5()		rand7()
	 * 1			1
	 * 2			2
	 * 3			3
	 * 4			4
	 * 5			5
	 * 				6
	 * 				7
	 * 
	 * We can't expand the result of a single call into 'more' data. Can't map 5 values to 7.
	 * 
	 * We need to call rand5() more than once and combine the results. We need to map 1-7 to the 
	 * possible values that will result in multiple calls to rand5().
	 *
	 * 2 calls to rand5()
	 * 
	 * x	1	2 	3	4	5
	 * 1	1	2	3	4	5
	 * 2	6	7	1	2	3
	 * 3	4	5	6	7	1
	 * 4	2	3	4	5	6
	 * 5	7	-	-	-	-
	 * 
	 * Need rand5 + rand3()-1
	 * 
	 * @return
	 */
	
	public int rand7(){
		
		// We need to expand the range then divide it evenly into sections divisible by 7
		
		// rand5() 1-5 * rand5() 1-5
		// creates range of 1-25, where we have 3 groups of 7 ints, and 4 to discard
		// we want to expand so we can create every value between 1-25 using 2 calls
		
		//			   5 * (0-4) 	   + (1-5)
		//			   0				1
		//			   5				2
		//			   10				3
		//			   15				4
		//             20				5
		// this will be between 1 and 25
		int expanded = 5 * (rand5()-1) + rand5();
		
		// 22, 23, 24, 25 would give us uneven distribution, remove them.
		while(expanded > 21){
			// Recalculate
			expanded = 5 * (rand5()-1) + rand5();
		}

		return expanded % 7 + 1;
	}
	
	public int rand5(){
		return ThreadLocalRandom.current().nextInt(1, 5 + 1);
	}
}

package com.fkujikis.playground.puzzles;

/**
 * You have a function rand7() that generates a random integer from 1 to 7. 
 * Use it to write a function rand5() that generates a random integer from 1 to 5.
 * 
 * rand7() returns each integer with equal probability. rand5() must also return each integer with equal probability.
 */



public class SimulateRand5UsingRand7 {

	private int rand7Counter = 0;
	
	/**
	 * Simpler case: use rand5() to simulate rand3()
	 * 
	 * rand5()	rand3()
	 * 1		1
	 * 2		2
	 * 3		3
	 * 4
	 * 5
	 * 
	 * We can map rand5() into rand3() range, but we won't have a fair distribution - some values will come up more.
	 * 
	 * r5	x3		/5		%3
	 * 1	3		0		0
	 * 2	6		1		1
	 * 3	9		1		1
	 * 4	12		2		2
	 * 5	15		3		0
	 * 
	 * The only way to have a fair distribution is to throw away the additional values.
	 * 
	 * If rand7() was truly random we could potentially run the loop forever as it would never terminate.
	 * 
	 * However if rand7() returns each integer with equal probability, it means that 5 of 7 or 50 of 70 iterations
	 * will result in the loop terminating properly, so that should never happen.
	 * 
	 * @return
	 */
	public int rand5(){
		int result = rand7();
		while(result > 5){
			result = rand7();
		}
		return result;
	}
	
	
	
	
	/**
	 * Produces an even distribution using a counter, but non-random. 
	 * Results in equal probability of getting each integer if called a multiple of 7 times. 
	 */
	public int rand7(){
		
		if(rand7Counter == 7){
			rand7Counter = 0;
		}
		
		return ++rand7Counter;
	}
	
}

package com.fkujikis.playground.simple;


public class HackRank_Summation {
	  
	private static int summation(int[] numbers) {
		if(numbers.length < 1 || numbers.length  > 10000){
			return -1;
		}
		
		int total = 0;
		for(int i = 1; i < numbers.length ; i++){
			if(numbers[i] < 1 || numbers[i] > 10000){
				return -1;
			}
			total += numbers[i];
		}
		
		return total;
	}
	
	public static void main(String[] args){
		int res = summation(new int[]{5,1,2,3,4,5});
		System.out.println(res);
		int res2 = summation(new int[]{2,12,12});
		System.out.println(res2);
	}
}

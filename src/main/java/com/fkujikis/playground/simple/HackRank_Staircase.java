package com.fkujikis.playground.simple;

public class HackRank_Staircase {

	
	public static void stairCase(int n){
		
		if(n < 1 || n > 100){
			return;
		}
		
		for(int row = 0; row < n; row++){
			
			// print spaces
			for(int i = 0; i < (n-row-1); i++){
				System.out.print(" ");
			}
			
			// print steps
			for(int j = (n-row-1); j < n; j++){
				System.out.print("#");
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args){
		stairCase(1);
		stairCase(6);
		stairCase(10);
	}
	
}

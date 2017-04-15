package com.fkujikis.playground.puzzles;


/**
 * Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 stock.
 * 
 * Stock must be bought before it's sold. You may not buy and sell in the same time step.
 * 
 * The input is an array of prices, 1 per time step.
 */

public class StockMaxProfit {

	//  stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
		
	// solution is 6 : buy at 5, sell at 11
	
	public int calculateMaxStockProfitSimple(int[] prices){
		
		// Simple approach:
		// - for each price calculate the profit comparing to every other element after it
		// - calculate and track the maximum profit
		// - return the maximum profit when finished
		// - this is 0(n^2) - iterate through the rest of the array for each element
		
		int maxProfit = 0;
		
		if(prices.length > 1){
			maxProfit = prices[1] - prices[0];
		}
		
		for(int i = 0; i < prices.length; i++){
			int currentPrice = prices[i];
			for(int j = i+1; j < prices.length; j++){
				int profit = prices[j] - currentPrice;
				if(profit > maxProfit){
					maxProfit = profit;
				}
			}
		}
		
		return maxProfit;
	}
	
	public int calculateMaxStockProfit(int[] prices){
		
		// - want to have a single pass through the array
		// - update and track the maximum profit, and fields to calculate it
		// - track the minimum index
		// - track the maximum index
		// - update max profit
		
		int minPrice = prices[0];
		int maxProfit = 0;
		
		if(prices.length > 1){
			maxProfit = prices[1] - prices[0];
		}
		
		for(int i = 0; i < prices.length; i++){
			
			// On the first iteration profit will always be 0
			// meaning there is a negative profit possible it will never be found
			if(i == 0) continue;
			
			int price = prices[i];

			int profit = price - minPrice;
			
			maxProfit = Math.max(profit, maxProfit);
			
			minPrice = Math.min(minPrice, price);
		}
		
		return maxProfit;
	}
	
}

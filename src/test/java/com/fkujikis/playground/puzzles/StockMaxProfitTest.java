package com.fkujikis.playground.puzzles;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockMaxProfitTest {

	private StockMaxProfit smp = new StockMaxProfit();
	
	private int[] prices1 = {10, 7, 5, 8, 11, 9};
	private int profit1 = 6;
	
	private int[] prices2 = {10, 17, 0, 0, 1, 91};
	private int profit2 = 91;
	
	private int[] prices3 = {15, 87, 23, 55, 84, 1, 2, 3, 4, 10, 0, 20, 30, 5, 4, 3, 77, 22};
	private int profit3 = 77;

	private int[] prices4 = {1, 87, 23, 55, 84, 1, 2, 3, 4, 10, 0, 20, 30, 5, 4, 3, 77, 122};
	private int profit4 = 122;
	
	private int[] pricesDescending = {5, 3, 2, 1};
	private int negativeProfit = -1;
	
	
	
	@Test
	public void testCalculateMaxStockProfitSimple() {
		assertEquals(profit1, smp.calculateMaxStockProfitSimple(prices1));
		assertEquals(profit2, smp.calculateMaxStockProfitSimple(prices2));
		assertEquals(profit3, smp.calculateMaxStockProfitSimple(prices3));
		assertEquals(profit4, smp.calculateMaxStockProfitSimple(prices4));
		assertEquals(negativeProfit, smp.calculateMaxStockProfitSimple(pricesDescending));
	}
	
	@Test
	public void testCalculateMaxStockProfit() {
		assertEquals(profit1, smp.calculateMaxStockProfit(prices1));
		assertEquals(profit2, smp.calculateMaxStockProfit(prices2));
		assertEquals(profit3, smp.calculateMaxStockProfit(prices3));
		assertEquals(profit4, smp.calculateMaxStockProfit(prices4));
		assertEquals(negativeProfit, smp.calculateMaxStockProfit(pricesDescending));
	}

}

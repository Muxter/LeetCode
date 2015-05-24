/**
 *	Say you have an array for which the ith element is the price of a given stock on day i.
 *
 *	If you were only permitted to complete at most one transaction 
 *	(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 *	Author: matao
 *
 */

public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < n; i++) {
			min = prices[i] < min ? prices[i] : min;
			profit = (prices[i] - min) > profit ? prices[i] - min : profit;
		}
		return profit;
    }

    public static void main(String[] args) {
    	int[] prices = {3, 2, 3, 1, 2};
    	System.out.println(maxProfit(prices));	
    }
}
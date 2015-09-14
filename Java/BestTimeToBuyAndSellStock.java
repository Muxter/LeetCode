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
		int buyTime = 0, sellTime = 0, maxProfit = 0, currProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			sellTime = i;
			currProfit = prices[sellTime] - prices[buyTime];
			if(currProfit <= 0) {
				buyTime = i;
			}

			if (currProfit > maxProfit) {
				maxProfit = currProfit;
			}
		}
		return maxProfit;
    }

    public static void main(String[] args) {
    	int[] prices = {3, 2, 3, 1, 2};
    	System.out.println(maxProfit(prices));
    }
}
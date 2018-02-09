package leetcode.arrays;

public class BestTimeToSellStockII {

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i. Design an algorithm to find the maximum profit. You may
	 * complete as many transactions as you like (ie, buy one and sell one share
	 * of the stock multiple times). However, you may not engage in multiple
	 * transactions at the same time (ie, you must sell the stock before you buy
	 * again).
	 */

	/*
	 * The idea is to find a next day that is bigger than me Greedy, The
	 * difference between this and the normal one is that we searched the valley
	 * and the peek in the overall array while here we are searching the next
	 * valley and next peek.
	 */

	/* O(N) time and O(1) space, where N is the size of the array */
	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices.length < 2)
			return profit;
		// Find valley and peek then valley and peek and so on
		// until the array is traversed.
		for (int i = 0; i < prices.length; i++) {
			// find min. move while smaller.
			while (i + 1 < prices.length && prices[i + 1] <= prices[i])
				i++;
			int min = prices[i];
			i++; // check next day to sell stock.
			// Find Max. move while bigger
			while (i + 1 < prices.length && prices[i + 1] >= prices[i])
				i++;
			// Check before accessing, because i might be out of bound.
			if (i < prices.length)
				profit += prices[i] - min;
		}
		return profit;
	}

	// Another solution. Greedy
	public int maxProfitI(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

}

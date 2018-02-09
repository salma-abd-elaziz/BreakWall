package leetcode.arrays;

public class BestTimetoBuyandSellStock {

	// من الاخر بنحاول نجيب اصغر رقم ونجيب بعده اكبر رقم
	// The idea is to find maximum profit, when you buy a stock then selling it
	// in a following day,
	// so we need to find max(prices[j]−prices[i]), j > i as selling price is
	// price[j] and buying price is price[i].
	public int maxProfit(int[] prices) {
		int valley = Integer.MAX_VALUE;
		int peek = 0; // The minimum number that a valley can be is 0, prices is
						// +ve numbers.

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < valley) valley = prices[i];
			else if ((prices[i] - valley) > peek) peek = prices[i] - valley;
		}
		return peek;
	}
}

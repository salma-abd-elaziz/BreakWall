package leetcode;

public class Sqrt {

	/* Implement int sqrt(int x). O(log n) time*/
	public int mySqrt(int x) {
		if (x == 0) return 0;
		if (x == 1) return 1;
		int ans = 0;
		int start = 0;
		int end = x;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			// left
			if (mid > x / mid) { 
				end = mid - 1;
			} else { // Division is bigger.
				ans = mid;
				start = mid + 1;
			}
		}
		return ans;
	}
}

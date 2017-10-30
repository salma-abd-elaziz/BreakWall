package leetcode;

public class CountBinarySubstrings {
	/*
	 * Give a string s, count the number of non-empty (contiguous) substrings
	 * that have the same number of 0's and 1's, and all the 0's and all the 1's
	 * in these substrings are grouped consecutively.
	 */
	public int countBinarySubstrings(String s) {
		if (s == null) return 0;
		int length = s.length();
		// Dynamic programming.
		int[][] frontScan = new int[length][2];
		int[][] backScan = new int[length][2];

		// Add every element to the previous element.
		// The arrays is used to count the consecutively 0's in the first
		// column,
		// 1's in the second column.
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == '0') { // Count consecutively 0's.
				frontScan[i][0] = 1 + (i - 1 >= 0 ? frontScan[i - 1][0] : 0);
			} else { // Count consecutively 1's.
				frontScan[i][1] = 1 + (i - 1 >= 0 ? frontScan[i - 1][1] : 0);
			}
		}

		for (int i = length - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') { // Count consecutively 0's.
				backScan[i][0] = 1 + (i + 1 < length ? backScan[i + 1][0] : 0);
			} else { // Count consecutively 1's.
				backScan[i][1] = 1 + (i + 1 < length ? backScan[i + 1][1] : 0);
			}
		}
		// If length = 0 the algorithm will return 0.
		int numberOfSubstrings = 0;
		for (int i = 0; i < length - 1; i++) {
			numberOfSubstrings += Math.min(frontScan[i][0], backScan[i + 1][1]);
			numberOfSubstrings += Math.min(frontScan[i][1], backScan[i + 1][0]);
		}
		return numberOfSubstrings;

	}

}

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	/*
	 * Given four lists A, B, C, D of integer values, compute how many tuples
	 * (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
	 */

	/*
	 * O(N^3) time and O(N) space where N is the size the array This solution
	 * gives time limit exceeded
	 */
	public int fourSumCountI(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		if (A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1)
			return count;
		// Map for the d array , to look for a number = -(A[i] + B[j] + C[k])
		Map<Integer, Integer> dMap = new HashMap<Integer, Integer>();
		// Filling the map.
		for (int y = 0; y < D.length; y++) {
			dMap.put(D[y], dMap.getOrDefault(D[y], 0) + 1);
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				for (int k = 0; k < C.length; k++) {
					int target = (A[i] + B[j] + C[k]) * -1;
					count += dMap.getOrDefault(target, 0);
				}
			}
		}
		return count;
	}

	// O(N^2) time , O(N^2) space
	public int fourSumCountII(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		if (A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1)
			return count;
		// Map for the a+b, to look for a sum = -(C[i] + D[j])
		Map<Integer, Integer> dMap = new HashMap<Integer, Integer>();
		// Filling the map.
		for (int y = 0; y < A.length; y++) {
			for (int h = 0; h < B.length; h++) {
				dMap.put(A[y] + B[h], dMap.getOrDefault(A[y] + B[h], 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int target = (C[i] + D[j]) * -1;
				count += dMap.getOrDefault(target, 0);
			}
		}
		return count;
	}
}

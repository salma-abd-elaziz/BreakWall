package leetcode.arrays;

public class ContainerWithMostWater {

	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * end points of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 */

	// O(n) time, where n is the length of the array.
	public int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int maxArea = Integer.MIN_VALUE;
		// Using two pointers, Move the smaller one and calculate the aarea and
		// update the maxArea if needed.
		int p0 = 0;
		int p1 = height.length - 1;
		while (p0 != p1) {
			int curArea = Math.min(height[p0], height[p1]) * (p1 - p0);
			maxArea = Math.max(maxArea, curArea);
			if (height[p0] < height[p1])
				p0++;
			else
				p1--;
		}
		return maxArea;
	}
}

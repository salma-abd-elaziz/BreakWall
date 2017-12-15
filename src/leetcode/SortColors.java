package leetcode;

public class SortColors {

	/*
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 */
	public void sortColors(int[] nums) {
		int p0 = 0;
		int p1 = 0;
		int p2 = nums.length - 1;

		int mid = 1;

		while (p1 <= p2) {
			if (nums[p1] < mid) {
				swap(nums, p1, p0);
				p1++;
				p0++;
			} else if (nums[p1] > mid) {
				swap(nums, p1, p2);
				p2--;
			} else p1++;
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

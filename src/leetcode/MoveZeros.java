package leetcode;

public class MoveZeros {

	/* https://leetcode.com/problems/move-zeroes/description/ */

	public void moveZeroes(int[] nums) {
		if (nums == null)
			return;
		// p0 used to find the first zero element, p1 always on the first
		// nonzero
		// element and it must be bigger than p0.
		int p0 = 0, p1 = 0;
		// find p0 and p1 initially.

		while (p0 >= 0 && p0 < nums.length && p1 >= 0 && p1 < nums.length) {
			while (p0 < nums.length && nums[p0] != 0)
				p0++;
			p1 = p0;
			while (p1 < nums.length && nums[p1] == 0)
				p1++;
			if (p1 >= nums.length)
				break; // Finished.
			swap(nums, p0, p1);
		}
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}

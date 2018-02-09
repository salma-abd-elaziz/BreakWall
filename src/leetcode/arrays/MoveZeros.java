package leetcode.arrays;

public class MoveZeros {

	/* https://leetcode.com/problems/move-zeroes/description/ */

	public void moveZeroes(int[] nums) {
		if (nums == null)
			return;

		int p0 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, p0++);
			}
		}
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
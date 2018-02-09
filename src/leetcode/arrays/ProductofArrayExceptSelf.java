package leetcode.arrays;

public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] = right * output[i];
			right *= nums[i];
		}
		return output;
	}
}

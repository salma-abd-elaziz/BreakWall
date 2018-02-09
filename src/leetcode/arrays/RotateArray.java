package leetcode.arrays;

public class RotateArray {

	/*
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4].
	 */
	
	//O(n) time, O(1) space.
	public void rotateArray(int[] nums, int k) {
		if (nums.length < 2 || k == 0) return;
        k %= nums.length; 
        int count = 0;
        for (int j = 0; count < nums.length; j++) {
            int elem = nums[j];
            int i = j;
            do {
                i = (i + k) % nums.length;
                int temp = nums[i];
                nums[i] = elem;
                elem = temp;
                count++;
            } while (i != j); 
        }
	}
}

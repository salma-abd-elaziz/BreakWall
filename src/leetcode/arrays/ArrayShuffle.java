package leetcode.arrays;

import java.util.Random;

public class ArrayShuffle {
	private int[] nums;
	private int[] temp;

	/*
	 * Start from 0 till the last element, choosing a random element preceding i
	 * to swap with it. O(n) time, O(n) space.
	 */
	public ArrayShuffle(int[] nums) {
		this.nums = nums;
		temp = new int[nums.length];
		clone(nums, temp);
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return temp;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		clone(temp, nums);
		Random rand = new Random();

		int min = 0;
		int max = nums.length; // exclusive.

		for (int i = 0; i < nums.length; i++) {
			int range = max - min;
			int index = rand.nextInt(range) + min;
			swap(nums, i, index);
			// Update min.
			min++;
		}
		return nums;
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	// Deep cloning.
	public void clone(int[] arr, int[] copy) {
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
	}

}

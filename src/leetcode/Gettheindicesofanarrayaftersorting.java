package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Gettheindicesofanarrayaftersorting {

	/* Get the indices of an array after sorting */

	class ArrayIndexComparator implements Comparator<Integer> {
		private int[] nums;

		public ArrayIndexComparator(int[] nums) {
			this.nums = nums;
		}

		public int compare(Integer o1, Integer o2) {
			return nums[o1] - nums[o2];
		}

		public Integer[] createIndexArray() {
			Integer[] arr = new Integer[nums.length];
			for (int i = 0; i < nums.length; i++) {
				arr[i] = i;
			}
			return arr;
		}
	}

	/*
	 * returns the index array of the elements in sorted order.
	 * access the array by iterating the indexArray this will 
	 * give the right order with the old  index
	 */
	public Integer[] indexTrackingSort(int[] nums) {
		Comparator<Integer> c = new ArrayIndexComparator(nums);
		Integer[] indexArray = ((ArrayIndexComparator) c).createIndexArray();
		Arrays.sort(indexArray, c);
		return indexArray;
	}

}

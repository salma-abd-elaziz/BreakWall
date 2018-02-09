package leetcode.sum;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {

	 /* Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 */
	 public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        // Map to hold the numbers in the array, key is the number 
	        // and value is the index in the array. 
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < nums.length; i++) {
	            // Look for the other number in the map, if not found index will equal -1.
	            int index = map.getOrDefault(target - nums[i], -1);
	            // if the other number was found. 
	            if (index != -1) {
	                // Add the current index and the found index and return.
	                result[0] = index;
	                result[1] = i;
	                break;
	            }
	            map.put(nums[i], i);
	        }
	        return result;
	    }
}

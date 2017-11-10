package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        // Using the two sum problem to solve this problem,
        // by finding the if there is 2 number equals the third one.
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            // to not search twice for the same number. (-c)
            if(i > 0 && nums[i] == nums[i-1]) continue; 
            // search for the number in the rest of the array. a+b = -c
            List<List<Integer>> twoSum = twoSum(nums,-1 * nums[i], i+1);
            for (List<Integer> list : twoSum) {
                list.add(0, nums[i]); // Add the smallest element in the beginnig.
                result.add(list);
            }
        }
        return result;
        
    }
    
   public List<List<Integer>> twoSum(int[] numbers, int target, int element) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = element; i < numbers.length - 1; i++) {
            // to not search twice for the same number. (a)
            if(i > element && numbers[i] == numbers[i-1]) continue; 
            // The binary search already returns the first element it finds so no need to handle b duplicates.
            int searchResult = binarySearch(numbers, i+1, numbers.length - 1, target - numbers[i]);
            // Check for error code.
            if (searchResult != -1) { // Solution found.
                List<Integer> list = new ArrayList<Integer>();
                list.add(numbers[i]);
                list.add(numbers[searchResult]);
                // Add to result.
                result.add(list);
            }
        }
        return result;
    }
    
    private int binarySearch(int[] arr, int start, int end, int target) {
        // check your indices.
        if (start > end) return -1; // Error code.
            
        int mid = (start + end) / 2;
        if (arr[mid] == target) return mid; // Found.
        
        if (target < arr[mid]) return binarySearch(arr, start, mid - 1, target);
        return binarySearch(arr, mid + 1, end, target);
    }
}

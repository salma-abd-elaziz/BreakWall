package leetcode;

public class SortedTwoSum {
	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int searchResult = binarySearch(numbers, i+1, numbers.length - 1, target - numbers[i]);
            // Check for error code.
            if (searchResult != -1) { // Solution found.
                // One-based.
                result[0] = i + 1;
                result[1] = searchResult + 1;
                break;
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

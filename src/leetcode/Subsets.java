package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        subsets(result, new ArrayList() ,nums, 0);
	        return result;
	    }
	    
	    public void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
	        result.add(new ArrayList(list));
	        for (int i = start; i < nums.length ; i++) {
	            list.add(nums[i]);
	            subsets(result, list, nums, i+1);
	            list.remove(list.size() - 1);
	        }
	    }
	
}

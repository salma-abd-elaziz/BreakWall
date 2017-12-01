package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/* Given an array of strings, group anagrams together. */

	// O(NKlogK) where N is the number of string in the array 
	// K is the number of chars in the largest string, O(N * k) space
	public List<List<String>> getGroupedAnagrams(String[] strs) {
		if (strs.length < 1)
			return new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] charArray = str.toCharArray(); // Extra space.
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);
			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<String>());
			}
			map.get(sortedStr).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}

	// O(N * K) time, O(1) 
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        // key : #digit#digit#digit... , digit represent the number of occurance of letter i.
        // abcz => #1#1#1#0#0#0#0...#1 
        for (String str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            } 
            map.get(key).add(str);
        }
       return new ArrayList<List<String>>(map.values());
    }
    
    
    private String getKey(String str) {
        int[] arr = new int[26]; // Extra Space. constant
        for (char c : str.toCharArray()) arr[c - 'a']++;
        
        // Add #.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
	
}

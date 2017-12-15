package leetcode;

public class Launcher {
	
	public static void main(String[] args) {
		LongestSubstringWhichContains2UniqueCharacters o = new LongestSubstringWhichContains2UniqueCharacters();
		int c = o.longestSubstringWithKUniqueChacaters("aaaabcaabaaa", 2);
		System.out.println(c);
		System.out.println(Integer.MAX_VALUE);
		
	}
}

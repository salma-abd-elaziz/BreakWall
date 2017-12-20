package leetcode;

import java.util.*;

public class Launcher {
	
	public static void main(String[] args) {
		ScenesPartitioning o = new ScenesPartitioning();
		
		char[] p = {'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h',
				'i', 'j', 'h', 'k', 'l', 'i', 'j'};
		o.videoParition(p);
		
		WordLadder oo = new WordLadder();
		List<String> set  = new ArrayList<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		set.add("cog");
		
		oo.ladderLength("hit", "cog", set);
		
	}
}

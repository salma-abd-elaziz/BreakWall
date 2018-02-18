package leetcode;

import java.util.*;

import leetcode.arrays.FindAllDuplicatesinanArray;
import leetcode.mathANDnumbers.ComplexNumberMultiplication;

public class Launcher {
	
	public static void main(String[] args) {
//		ScenesPartitioning o = new ScenesPartitioning();
//		
//		char[] p = {'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h',
//				'i', 'j', 'h', 'k', 'l', 'i', 'j'};
//		o.videoParition(p);
//		
//		WordLadder oo = new WordLadder();
//		List<String> set  = new ArrayList<String>();
//		set.add("hot");
//		set.add("dot");
//		set.add("dog");
//		set.add("lot");
//		set.add("log");
//		set.add("cog");
//		
//		oo.ladderLength("hit", "cog", set);
		FindAllDuplicatesinanArray a =  new FindAllDuplicatesinanArray();
		int[] aa = {9,4,9,2,7,8,8,3,4};
		a.findDuplicates(aa);
		
	}
}

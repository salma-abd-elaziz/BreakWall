package leetcode;

import java.util.*;

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
		ComplexNumberMultiplication a = new ComplexNumberMultiplication();
		
		System.out.println( "answer : " + a.complexNumberMultiply("-1", "1i"));
		
	}
}

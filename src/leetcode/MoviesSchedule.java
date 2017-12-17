package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MoviesSchedule {

	/*
	 * Given these movies schedule, return max number of movies you can watch.
	 * a: [1,2], [2,3], [6,7] 
	 * b: [2,4] 
	 * c: [3,5]
	 */
	
	class Node{
		int inBound;
		List<Integer> adj;
		public Node() {
			inBound = 0;
			adj = new ArrayList<Integer>();
		}
	}
	
	//Topological sort.
	public int findMaxMoviesNum (int[][] order) {
		int maxCount = 0;
		// the graph
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		
		// in array [v, u] => in graph (u, v) 
		for (int i = 0; i < order.length; i++) {
			Node v = map.getOrDefault(order[i][0],new Node());			
			Node u = map.getOrDefault(order[i][0],new Node());
			map.putIfAbsent(order[i][0], v);
			map.putIfAbsent(order[i][1], u);
			
			v.inBound++;
			u.adj.add(order[i][0]);
		}
		
		// Topological sort queue.
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		return maxCount;		
	}
}

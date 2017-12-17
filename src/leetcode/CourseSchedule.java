package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {

	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 */

	// O(N) time, O(N) space where N is the number of dependencies.
	class Node {
		int inBoundCount;
		List<Integer> adjacencyList;

		public Node() {
			this.inBoundCount = 0;
			this.adjacencyList = new ArrayList<Integer>();
		}
	}

	// prerequisites is a list of edges, not the not the adjacency matrix.
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length < 1)
			return true;
		// map to get the adjacency list in O(1).
		Map<Integer, Node> map = new HashMap<Integer, Node>();

		// Count inBound and, assemble the adjacencyList.
		for (int i = 0; i < prerequisites.length; i++) {
			Node v = map.getOrDefault(prerequisites[i][0], new Node());
			Node u = map.getOrDefault(prerequisites[i][1], new Node());
			map.putIfAbsent(prerequisites[i][0], v);
			map.putIfAbsent(prerequisites[i][1], u);
			// add edge.
			u.adjacencyList.add(prerequisites[i][0]);
			// increment inBound.
			v.inBoundCount++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		for (Map.Entry<Integer, Node> e : map.entrySet()) {
			if (e.getValue().inBoundCount == 0)
				queue.add(e.getKey());
		}

		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int u : map.get(v).adjacencyList) {
				map.get(u).inBoundCount--;
				if (map.get(u).inBoundCount == 0)
					queue.add(u);
			}
			count++;
		}
		if (count == map.size()) return true;
		return false;
	}

}
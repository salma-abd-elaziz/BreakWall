package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

	class Node {
		int inBoundCount;
		List<Integer> adjacencyList;

		public Node() {
			this.inBoundCount = 0;
			this.adjacencyList = new ArrayList<Integer>();
		}
	}

	// prerequisites is a list of edges, not the not the adjacency matrix.
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		int index = 0;
		// map to get the adjacency list in O(1).
		Map<Integer, Node> map = new HashMap<Integer, Node>();

		// Count inBound and, assemble the adjacencyList. O(N)
		for (int i = 0; i < prerequisites.length; i++) {
			Node v = map.getOrDefault(prerequisites[i][0], new Node());
			Node u = map.getOrDefault(prerequisites[i][1], new Node());
			map.putIfAbsent(prerequisites[i][0], v);
			map.putIfAbsent(prerequisites[i][1], u);
			// add edge. ([v, u] => (u,v)) to do the sort the edge goes from the
			// earlier to the later.
			u.adjacencyList.add(prerequisites[i][0]);
			// increment inBound.
			v.inBoundCount++;
		}

		// Add of courses with no dependencies, add them frist.
		// Assuming the course numbers in sequence. 0, 1 , 2 ... , numCourses
		if (map.size() < numCourses) {
			for (int i = 0; i < numCourses; i++) {
				if (!map.containsKey(i))
					res[index++] = i;
			}
		}

		// Topological sort algorithm.
		Queue<Integer> queue = new LinkedList<Integer>();
		// O(N)
		for (Map.Entry<Integer, Node> e : map.entrySet()) {
			if (e.getValue().inBoundCount == 0)
				queue.add(e.getKey());
		}

		// O(N)
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int u : map.get(v).adjacencyList) {
				map.get(u).inBoundCount--;
				if (map.get(u).inBoundCount == 0)
					queue.add(u);
			}
			res[index++] = v;
		}
		if (index == numCourses) return res;
		return new int[0];
	}
}

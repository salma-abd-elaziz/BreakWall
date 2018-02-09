package leetcode.graphs;

public class FriendCircles {

	/*
	 * There are N students in a class. Some of them are friends, while some are
	 * not. Their friendship is transitive in nature. For example, if A is a
	 * direct friend of B, and B is a direct friend of C, then A is an indirect
	 * friend of C. And we defined a friend circle is a group of students who
	 * are direct or indirect friends.
	 * 
	 * Given a N*N matrix M representing the friend relationship between
	 * students in the class. If M[i][j] = 1, then the ith and jth students are
	 * direct friends with each other, otherwise not. And you have to output the
	 * total number of friend circles among all the students.
	 */

	public void DFS(int[][] M, boolean[] visited, int v) {
		visited[v] = true;
		for (int i = 0; i < M.length; i++) {
			if (!visited[i] && M[v][i] == 1) {
				DFS(M, visited, i);
			}
		}
	}

	public int findCircleNum(int[][] M) {
		boolean[] visited = new boolean[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				count++;
				DFS(M, visited, i);
			}
		}
		return count;
	}
}

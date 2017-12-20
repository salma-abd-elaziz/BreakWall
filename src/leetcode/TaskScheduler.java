package leetcode;

public class TaskScheduler {
	/*
	 * Given a char array representing tasks CPU need to do. It contains capital
	 * letters A to Z where different letters represent different tasks.Tasks
	 * could be done without original order. Each task could be done in one
	 * interval. For each interval, CPU could finish one task or just be idle.
	 * 
	 * However, there is a non-negative cooling interval n that means between
	 * two same tasks, there must be at least n intervals that CPU are doing
	 * different tasks or just be idle.
	 * 
	 * You need to return the least number of intervals the CPU will take to
	 * finish all the given tasks.
	 */

	public int leastInterval(char[] tasks, int n) {
		// By counting the ideal intervals.
		int[] map = new int[26];

		// Count the number of each task.
		for (char c : tasks)
			map[c - 'A']++;

		// find the maximum count.
		int maxValueIndex = findMax(map);
		int maxValue = map[maxValueIndex] - 1;
		// The maximum number of ideal interval equlas the maximum count * n.
		int IdealIntervalsNo = maxValue * n;

		// Remove the extra ideal intervals.
		for (int i = 0; i < map.length; i++) {
			if (i == maxValueIndex)
				continue;
			IdealIntervalsNo -= Math.min(maxValue, map[i]);
		}
		// it could be -ve if there is no ideal intervals
		return IdealIntervalsNo > 0 ? tasks.length + IdealIntervalsNo : tasks.length;
	}

	private int findMax(int[] map) {
		int index = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[index] < map[i]) {
				index = i;
			}
		}
		return index;
	}

}

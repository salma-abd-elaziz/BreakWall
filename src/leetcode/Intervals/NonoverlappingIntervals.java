package leetcode.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {

	/*
	 * Given a collection of intervals, find the minimum number of intervals you
	 * need to remove to make the rest of the intervals non-overlapping.
	 */
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	// Dual problem of maximum number of non-overlapping intervals.
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length < 1)
			return 0; // error
		// Sort by ends.
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval first, Interval second) {
				return first.end - second.end;
			}
		};
		Arrays.sort(intervals, comp);
		// Find the maximum number of non-overlapping intervals.
		Interval first = intervals[0];
		int count = 1;
		for (int i = 1; i < intervals.length; i++) {
			Interval second = intervals[i];
			// Non-overlapping?
			if (first.end <= second.start) {
				count++;
				first = second;
			}
		}
		return intervals.length - count;
	}
}

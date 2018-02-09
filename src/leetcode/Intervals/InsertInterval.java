package leetcode.Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	/*
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
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

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() < 1) {
			List<Interval> res = new ArrayList<Interval>();
			res.add(newInterval);
			return res;
		} // empty, insert new.

		insertInPlace(intervals, newInterval);
		// return intervals;
		return mergeSortedIntervals(intervals);
	}

	public int compare(Interval left, Interval right) {
		if (left.start != right.start)
			return left.start - right.start;
		return left.end - right.end;
	}

	public void insertInPlace(List<Interval> intervals, Interval newInterval) {
		boolean found = false;
		for (int i = 0; i < intervals.size(); i++) {
			if (compare(intervals.get(i), newInterval) > 0) { // bigger than 0.
				found = true;
				intervals.add(i, newInterval);
				break;
			}
		}
		if (!found)
			intervals.add(newInterval);
	}

	public List<Interval> mergeSortedIntervals(List<Interval> intervals) {
		Interval first = intervals.get(0);
		List<Interval> res = new ArrayList<Interval>();

		for (int i = 1; i < intervals.size(); i++) {
			Interval second = intervals.get(i);
			if (first.end < second.start) { // Stop merging.
				res.add(first); 
				first = second;
			} else {
				first = new Interval(first.start, Math.max(first.end, second.end));
			}
		}
		res.add(first);
		return res;
	}
}

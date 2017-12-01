package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	/* Given a collection of intervals, merge all overlapping intervals */

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

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() < 1) return res;
		// we need to sort the intervals
		// if Interval implements comparable we can write the function inside it
		// and use
		// Collection.sort(intervals) direct
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval left, Interval right) {
				if (left.start != right.start)
					return left.start - right.start;
				else
					return left.end - right.end;
			}

		};
		Collections.sort(intervals, comp);

		Interval first = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval second = intervals.get(i);
			if (first.end < second.start) { //stop merging
				res.add(first);
				first = second;
			} else { // merge
				// take first.start because it always will be bigger or equal second as we sorted 
				// but end, will take max because we are not sure which if bigger
				first = new Interval(first.start, Math.max(first.end, second.end));
			}
		}
		// Last Interval
		res.add(first);
		return res;
	}

}

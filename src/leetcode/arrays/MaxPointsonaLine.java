package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {

	/*
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 * 
	 */
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	// O(N^2) time, O(N) space, where N is the number of points in the array
	// But the double precision is not enough.
	public int maxPoints(Point[] points) {
		if (points == null || points.length < 1)
			return 0;
		// 1 point => max number is 1
		// 2 points => max number is 2
		if (points.length <= 2)
			return points.length;
		// count the points on each possible line in the input,
		// a line is two points, so try every 2 points
		int samePoint = 0;
		int maximumCount = Integer.MIN_VALUE;
		for (int i = 0; i < points.length; i++) {
			int sameX = 1;
			// slop as a key and the value are the number of points on that
			// line.
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y)
					samePoint++;
				// Check x because we can't divide by 0.
				if (points[i].x == points[j].x) {
					sameX++;
					continue;
				}
				// if the points has the same y the slop = 0 as a key in the map
				double slop = ((double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x));
				map.put(slop, map.getOrDefault(slop, 1) + 1);
				// (same slope + same point) on the current line
				maximumCount = Math.max(maximumCount, map.get(slop) + samePoint);
			}
			// check if the horixental line has more points.
			maximumCount = Math.max(maximumCount, sameX);
		}
		return maximumCount;
	}

	// O(n^2) time, O(n) space
	public int maxPointsI(Point[] points) {
		// The problem is that the division is not good as the precision is
		// not enough.
		// save the slop as (x) => y, where x/y is the slop.
		if (points == null || points.length < 1)
			return 0;
		// 1 point => max number is 1
		// 2 points => max number is 2
		if (points.length <= 2)
			return points.length;
		// count the points on each possible line in the input,
		// a line is two points, so try every 2 points
		int maximum = 0;
		for (int i = 0; i < points.length; i++) {
			int samePoint = 0;
			int localMaximum = 0;
			Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
			for (int j = i + 1; j < points.length; j++) {
				int xDiff = points[i].x - points[j].x;
				int yDiff = points[i].y - points[j].y;
				if (xDiff == 0 && yDiff == 0) {
					samePoint++;
					continue;
				}
				// find slop = xDiff/yDiff
				int gcd = findGCD(xDiff, yDiff);
				if (gcd != 0) {
					xDiff /= gcd;
					yDiff /= gcd;
				}
				Map<Integer, Integer> m = map.getOrDefault(xDiff, new HashMap<Integer, Integer>());
				map.putIfAbsent(xDiff, m);
				m.put(yDiff, m.getOrDefault(yDiff, 0) + 1);
				// if the point was duplicate it would not reach here.
				localMaximum = Math.max(localMaximum, m.get(yDiff));
			}
			// We continue in case of duplicates so we need to add it here.
			// samePoint + 1 number of duplicates.
			maximum = Math.max(maximum, localMaximum + samePoint + 1);
		}
		return maximum;
	}

	private int findGCD(int a, int b) {
		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}
}

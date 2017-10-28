package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class BreakWall {

	public int leastBricks(ArrayList<ArrayList<Integer>> wall) {
		int crossedBreakesNo =Integer.MIN_VALUE;
		HashMap<Integer, Integer> passedLines = new HashMap<>();
		for (int j = 0; j < wall.size(); j++) {
			ArrayList<Integer> row = wall.get(j);
			int sum = 0;
			for (int k = 0; k < row.size() - 1; k++) {
				sum += row.get(k);
				// Update the map that there is a line doesn't 
				// cross a break at length sum.
				if (passedLines.containsKey(sum)) {
					passedLines.put(sum, passedLines.get(sum)+1);
				} else {
				passedLines.put(sum, 1);
				}
			}
		}
		// find the maximum number in map ,that is the maximum number of breaks 
		// isn't being crossed by  a line.
		for (Integer breaksNo : passedLines.values()) 
			if (breaksNo > crossedBreakesNo) crossedBreakesNo = breaksNo;
		
		// // in case the wall was on the special case [[l],[l],....,[l]].
		if (crossedBreakesNo == Integer.MIN_VALUE) return wall.size();
		// Return the number of crossed breaks.
		return wall.size() - crossedBreakesNo;
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BreakWall {

	public int leastBricks(ArrayList<ArrayList<Integer>> wall) {
		int crossedBreakesNo =Integer.MAX_VALUE;
		// To know where to try to put a line.
		Set<Integer> placeToTry= new HashSet<Integer>();
		for (int j = 0; j < wall.size(); j++) {
			ArrayList<Integer> row = wall.get(j);
			int sum = 0;
			for (int k = 0; k < row.size() - 1; k++) {
				sum += row.get(k);
				placeToTry.add(sum);
			}
		}

		// For each unit in the length, try to draw the line.
		for (Integer i : placeToTry){
			int lineCrossedBreakesNo = 0;
			for (int j = 0; j < wall.size(); j++) {
				ArrayList<Integer> row = wall.get(j);
				int sum = 0;
				for (int k = 0; k < row.size(); k++) {
					sum += row.get(k);
					if (sum == i)
						break; // Not crossed.
					if (sum > i) { // crossed.
						lineCrossedBreakesNo++;
						break;
					}
				}
			}
			// After finding the no of crossed breaks at line i.
			if (crossedBreakesNo > lineCrossedBreakesNo)
				crossedBreakesNo = lineCrossedBreakesNo;
		}
		// in case the wall was on the special case [[l],[l],....,[l]].
		return crossedBreakesNo == Integer.MAX_VALUE? wall.size() : crossedBreakesNo;
	}

}

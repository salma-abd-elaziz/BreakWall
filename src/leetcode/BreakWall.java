package leetcode;

import java.util.ArrayList;
public class BreakWall {

	public int leastBricks(ArrayList<ArrayList<Integer>> wall) {
		int length = 0, crossedBreakesNo = Integer.MAX_VALUE;
		// Find the length of the wall.
		for (int i = 0; i < wall.get(0).size(); i++) {
			length += wall.get(0).get(i);
		}
		// in case the wall was on the special case [[l],[l],....,[l]].
		boolean found = false;
		for (int j = 1;!found && j < wall.size() ; j++) {
			if (wall.get(j).size() != wall.get(j-1).size()) found = true;
		}
		
		if (!found && wall.get(0).size() == 1) {
			
			return wall.size();
		}
		// For each unit in the length, try to draw the line.
		for (int i = 1; i < length; i++) {
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
		return crossedBreakesNo;
	}

}

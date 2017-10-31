package leetcode;

import java.util.ArrayList;

public class Launcher {
	
	public static void main(String[] args) {
		BreakWall s = new BreakWall();
		ArrayList<ArrayList<Integer>> wall = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(1);
		d.add(2);    
		d.add(2);
		d.add(1);
		
		wall.add(d);
		d = new ArrayList<Integer>();
		
		d.add(3);
		d.add(1);
		d.add(2);
		
		wall.add(d);
		d = new ArrayList<Integer>();
		
		d.add(1);
		d.add(3);
		d.add(2);
		 
		wall.add(d);
		d = new ArrayList<Integer>();
		
		
		
		d.add(2);
		d.add(4);
		
		wall.add(d);
		d = new ArrayList<Integer>();
		
		d.add(3);
		d.add(1);
		d.add(2);
		
		wall.add(d);
		d = new ArrayList<Integer>();
		
		d.add(1);
		d.add(3);
		d.add(1);
		d.add(1);
		
		
		wall.add(d);
		d = new ArrayList<Integer>();
		
		System.out.println(s.leastBricks(wall));

		
		
		
		
		wall = new ArrayList<ArrayList<Integer>>();
		
		d.add(100000000);
		wall.add(d);
		
		d = new ArrayList<Integer>();
		d.add(100000000);
		wall.add(d);
		
		d = new ArrayList<Integer>();
		d.add(100000000);
		wall.add(d);
		
		d = new ArrayList<Integer>();
		
		System.out.println(s.leastBricks(wall));
		
		//=====================
		SubarraySumEqualsk c = new SubarraySumEqualsk();
		int[] k = {1, 1 ,1};
		System.out.println(c.subarraySum(k, 2));
	}
}

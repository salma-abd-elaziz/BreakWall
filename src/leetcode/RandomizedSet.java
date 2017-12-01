package leetcode;
import java.util.*;

public class RandomizedSet {

	    private Map<Integer, Integer> map; // key : elem, value : index in the list.
	    private List<Integer> list;
	    private Random rand;
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        map = new HashMap<Integer, Integer>();
	        list = new ArrayList<Integer>();
	        rand = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if (map.containsKey(val)) return false;
	        map.put(val, list.size());
	        list.add(val);
	        return true;
	        
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if (!map.containsKey(val)) return false;
	        int index = map.get(val); // Get index.
	        if (index != list.size() - 1) {
	            // swap to delete the last elem in list to make it O(1).
	            int lastElem = list.get(list.size() - 1);
	            map.put(lastElem, index); // Update index of LastElem in map.
	            list.set(index, lastElem); // put lastElem in the place of the val because we will remove lastelem.
	        }
	        map.remove(val);
	        list.remove(list.size() - 1);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return list.get(rand.nextInt(list.size()));
	    }
	}


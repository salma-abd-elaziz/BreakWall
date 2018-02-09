package leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

	
	  // This is the interface that allows for creating nested lists.
	  // You should not implement it, or speculate about its implementation
	  public interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 

	    private List<Integer> contentList;
	    private int it; 

	    public NestedIterator(List<NestedInteger> nestedList) {
	        contentList = new ArrayList<Integer>();
	        flat(nestedList);
	        it = 0;
	    }
	    
	    private void flat(List<NestedInteger> nestedList) {
	        for (NestedInteger ni : nestedList) {
	            if (ni.isInteger()) contentList.add(ni.getInteger());
	            else flat(ni.getList());
	        }
	    }

	    @Override
	    public Integer next() {
	        return contentList.get(it++);
	    }

	    @Override
	    public boolean hasNext() {
	        return it < contentList.size();
	    }
	}

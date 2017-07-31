package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

	List<Integer> list=new ArrayList<Integer>();
	int nextIndex=0;
	int size;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		getList(nestedList, list);
		size=list.size();
	}
	
	private void getList(List<NestedInteger> nestedList,List<Integer> list){
		for(NestedInteger n:nestedList){
			if(n.isInteger()){
				list.add(n.getInteger());
			}
			else{
				getList(n.getList(), list);
			}
		}
	}

	@Override
	public Integer next() {
		if(nextIndex==size){
			return null;
		}
		Integer result=list.get(nextIndex);
		nextIndex++;
		return result;
	}

	@Override
	public boolean hasNext() {
		if(nextIndex==size){
			return false;
		}
		return true;
	}

}

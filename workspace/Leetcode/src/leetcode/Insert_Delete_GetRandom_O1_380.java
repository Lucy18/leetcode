package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Insert_Delete_GetRandom_O1_380 {

	//map中存储 <整数,该整数在list中的索引>
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;
	int size;
	Random random;
	
	 /** Initialize your data structure here. */
    public Insert_Delete_GetRandom_O1_380() {
        map=new HashMap<Integer,Integer>();
        list=new ArrayList<Integer>();
        size=0;
        random=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
        	return false;
        }
        else{
        	map.put(val, size);
        	list.add(val);
        	size++;
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
        	int index=map.get(val);
        	map.remove(val);
        	for(int i=index+1;i<size;i++){
        		map.put(list.get(i), map.get(list.get(i))-1);
        	}
        	list.remove(index);
        	size--;
        	return true;
        }
        else{
			return false;
		}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index=random.nextInt(size);
        return list.get(index);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insert_Delete_GetRandom_O1_380 obj = new Insert_Delete_GetRandom_O1_380();
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.insert(3));
		System.out.println(obj.insert(4));
		System.out.println(obj.remove(2));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(4));
		System.out.println(obj.getRandom());
	}

}

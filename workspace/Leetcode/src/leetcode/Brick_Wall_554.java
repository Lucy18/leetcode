package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Brick_Wall_554 {

	public int leastBricks(List<List<Integer>> wall) {
		int totalHeight=wall.size();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int maxCount=0;
		for(List<Integer> list:wall){
			int width=0;
			for(int i=0;i<list.size()-1;i++){
				width+=list.get(i);
				int count=map.getOrDefault(width, 0);
				count++;
				map.put(width, count);
				if(count>maxCount){
					maxCount=count;
				}
			}
		}
		int result=totalHeight-maxCount;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brick_Wall_554 b=new Brick_Wall_554();
		List<List<Integer>> wall=new ArrayList<List<Integer>>();
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);list1.add(2);list1.add(2);list1.add(1);
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(3);list2.add(1);list2.add(2);
		List<Integer> list3=new ArrayList<Integer>();
		list3.add(1);list3.add(3);list3.add(2);
		List<Integer> list4=new ArrayList<Integer>();
		list4.add(2);list4.add(4);
		List<Integer> list5=new ArrayList<Integer>();
		list5.add(3);list5.add(1);list5.add(2);
		List<Integer> list6=new ArrayList<Integer>();
		list6.add(1);list6.add(3);list6.add(1);list6.add(1);
		wall.add(list1);
		wall.add(list2);
		wall.add(list3);
		wall.add(list4);
		wall.add(list5);
		wall.add(list6);
		System.out.println(b.leastBricks(wall));
	}

}

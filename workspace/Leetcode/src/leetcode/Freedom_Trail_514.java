package leetcode;

import java.util.HashMap;

public class Freedom_Trail_514 {

	public int findRotateSteps(String ring, String key) {
		char[] cs=ring.toCharArray();
		HashMap<Integer, HashMap<Integer, Integer>> map=new HashMap<Integer, HashMap<Integer, Integer>>();
		return findRotateSteps(cs, key, 0, 0, map);
	}
	
	public int findRotateSteps(char[] cs, String key,int index, 
			int position_12,HashMap<Integer, HashMap<Integer, Integer>> map) {
		if (index == key.length()) {
			return 0;
		}
		if(map.get(position_12)!=null&&map.get(position_12).get(index)!=null){
			return map.get(position_12).get(index);
		}
		int n = cs.length;
		int clockwisePointer = position_12;
		int anticlockwisePointer = position_12;
		char target = key.charAt(index);
		int clockwiseStep = 0;
		while (cs[clockwisePointer] != target) {
			clockwisePointer = (clockwisePointer + 1) % n;
			clockwiseStep++;
		}
		int anticlockwiseStep = 0;
		while (cs[anticlockwisePointer] != target) {
			anticlockwisePointer = (anticlockwisePointer - 1 + n) % n;// 因为-1%3=-1
			anticlockwiseStep++;
		}
		int count=Math.min(
				clockwiseStep+1+findRotateSteps(cs, key, index+1, clockwisePointer,map), 
				anticlockwiseStep+1+findRotateSteps(cs, key, index+1, anticlockwisePointer,map));
		HashMap<Integer, Integer> value=map.getOrDefault(position_12, new HashMap<Integer, Integer>());
		value.put(index, count);
		map.put(position_12, value);
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Freedom_Trail_514 f=new Freedom_Trail_514();
//		System.out.println(f.findRotateSteps("nyngl", "yyynnnnnnlllggg"));
		System.out.println(f.findRotateSteps("caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
	}

}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Maximum_Length_of_Pair_Chain_646 {

	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs,(a,b) -> a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int longest=0;
		for(int i=0;i<pairs.length;i++){
			int count=longestChainFromThisIndex(pairs, i, map);
			if(count>longest){
				longest=count;
			}
		}
		return longest;
	}
	
	//从该index开始的最大链长度（包含该index）
	public int longestChainFromThisIndex(int[][] pairs,int index,
			HashMap<Integer, Integer> map){
		if(index==pairs.length){
			return 0;
		}
		if(map.get(index)!=null){
			return map.get(index);
		}
		int end=pairs[index][1];
		int pointer=index+1;
		while(pointer<pairs.length&&pairs[pointer][0]<=end){
			pointer++;
		}
		int nextLongest=0;
		for(int i=pointer;i<pairs.length;i++){
			int theLong=longestChainFromThisIndex(pairs, i, map);
			if(theLong>nextLongest){
				nextLongest=theLong;
			}
		}
		int count=1+nextLongest;
		map.put(index, count);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Length_of_Pair_Chain_646 m=new Maximum_Length_of_Pair_Chain_646();
		int[][] pairs=new int[][]{
			{-7, -1}, {0, 10}, {2, 3}, {3, 6}, {3, 10}, {4, 5}, {7, 9}, {7, 9}
		};
		System.out.println(m.findLongestChain(pairs));
	}

}

package leetcode;

import java.util.HashSet;

public class Longest_Consecutive_Sequence_128 {

	public int longestConsecutive(int[] nums) {
		HashSet<Integer> hashSet=new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			hashSet.add(nums[i]);
		}
		int maxConsecutive=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			int currentConsecutive=1;
			int val=num;
			while(hashSet.contains(val-1)){
				currentConsecutive++;
				hashSet.remove(val-1);
				val=val-1;
			}
			val=num;
			while(hashSet.contains(val+1)){
				currentConsecutive++;
				hashSet.remove(val+1);
				val=val+1;
			}
			if(currentConsecutive>maxConsecutive){
				maxConsecutive=currentConsecutive;
			}
		}
		return maxConsecutive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Consecutive_Sequence_128 l=new Longest_Consecutive_Sequence_128();
		int[] nums=new int[]{0,-1};
	//	int[] nums=new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
		System.out.println(l.longestConsecutive(nums));
	}

}

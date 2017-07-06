package leetcode;

import java.util.HashSet;

public class Contains_Duplicate_217 {

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet=new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			if(hashSet.contains(nums[i])){
				return true;
			}
			else{
				hashSet.add(nums[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contains_Duplicate_217 c=new Contains_Duplicate_217();
		int[] nums=new int[]{};
		System.out.println(c.containsDuplicate(nums));
	}

}

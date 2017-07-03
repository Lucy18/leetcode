package leetcode;

import java.util.HashMap;

public class Majority_Element_169 {

	public int majorityElement(int[] nums) {
		int n=nums.length;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			int count=map.getOrDefault(nums[i], 0)+1;
			if(count>n/2){
				return nums[i];
			}
			map.put(nums[i],count);
		}
		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Majority_Element_169 m=new Majority_Element_169();
		int[] nums=new int[]{1,2,3,3,3};
		System.out.println(m.majorityElement(nums));
	}

}



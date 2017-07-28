package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Combination_Sum_IV_377 {

	public int combinationSum4(int[] nums, int target) {
		if(nums.length==0){
			return 0;
		}
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		Arrays.sort(nums);
		int count=helper(nums, target,map);
		return count;
	}
	
	public int helper(int[] nums,int target,HashMap<Integer, Integer> map){
		if(target==0){
			return 1;
		}
		if(map.get(target)!=null){
			return map.get(target);
		}
		int count=0;;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<=target){
				count+=helper(nums, target-nums[i],map);
			}
		}
		map.put(target, count);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination_Sum_IV_377 c=new Combination_Sum_IV_377();
		int[] nums=new int[]{1,2,3};
		System.out.println(c.combinationSum4(nums, 32));
	}

}

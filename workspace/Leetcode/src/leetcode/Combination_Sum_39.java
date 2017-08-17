package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), 0, candidates, target);
		return res;
	}
	
	public void helper(List<List<Integer>> res,List<Integer> list,
			int index,int[] nums,int target){
		if(target==0){
			res.add(new ArrayList<>(list));
			return;
		}
		if(index>=nums.length){
			return;
		}
		helper(res, list, index+1, nums, target);
		int theNum=nums[index];
		int count=1;
		while(theNum*count<=target){
			for(int i=0;i<count;i++){
				list.add(theNum);
			}
			helper(res, list, index+1, nums, target-theNum*count);
			for(int i=0;i<count;i++){
				list.remove(list.size()-1);
			}
			count++;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination_Sum_39 c=new Combination_Sum_39();
		int[] nums=new int[]{2,3,6,7};
		List<List<Integer>> res=c.combinationSum(nums, 7);
		for(List<Integer> list:res){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}

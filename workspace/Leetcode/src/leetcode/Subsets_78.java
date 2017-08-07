package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<>();
		helper(nums, 0,result,list);
		return result;
	}
	
	public void helper(int[] nums,int index,
			List<List<Integer>> result,List<Integer> list){
		if(index==nums.length){
			result.add(list);
			return;
		}
		List<Integer> newList=new ArrayList<>(list);
		helper(nums, index+1, result, newList);
		newList=new ArrayList<>(list);
		newList.add(nums[index]);
		helper(nums, index+1, result, newList);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets_78 s=new Subsets_78();
		int[] nums=new int[]{1,2,3};
		List<List<Integer>> result=s.subsets(nums);
		for(List<Integer> list:result){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}

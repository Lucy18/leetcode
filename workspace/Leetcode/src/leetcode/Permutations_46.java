package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		permute(nums,0,nums.length-1,result);
		return result;
	}
	
	public void permute(int[] nums,int left,int right,List<List<Integer>> result){
		if(left==right){
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<nums.length;i++){
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}
		for(int i=left;i<=right;i++){
			swap(nums, left, i);
			permute(nums,left+1,right,result);
			swap(nums, left, i);
		}
	}
	
	public void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations_46 p=new Permutations_46();
		int[] nums=new int[]{1,2,3};
		List<List<Integer>> result=p.permute(nums);
		for(List<Integer> list:result){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}

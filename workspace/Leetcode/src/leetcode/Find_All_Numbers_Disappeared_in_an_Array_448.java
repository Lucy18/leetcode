package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array_448 {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list=new ArrayList<Integer>();
		int length=nums.length;
		for(int i=0;i<length;i++){
			int theVal=Math.abs(nums[i]);
			if(nums[theVal-1]>0){
				nums[theVal-1]=-nums[theVal-1];
			}
		}
		for(int i=0;i<length;i++){
			if(nums[i]>0){
				list.add(i+1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_All_Numbers_Disappeared_in_an_Array_448 f=new Find_All_Numbers_Disappeared_in_an_Array_448();
		int[] nums=new int[]{4,3,2,7,8,2,3,1};
		List<Integer> list=f.findDisappearedNumbers(nums);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}

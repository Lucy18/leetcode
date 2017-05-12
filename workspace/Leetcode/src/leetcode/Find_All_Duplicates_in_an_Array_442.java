package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array_442 {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res=new ArrayList<Integer>();
		int[] newNums=new int[nums.length+1];
		for(int i=0;i<nums.length;i++){
			newNums[nums[i]]++;
		}
		for(int i=1;i<newNums.length;i++){
			if(newNums[i]==2){
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_All_Duplicates_in_an_Array_442 f=new Find_All_Duplicates_in_an_Array_442();
		int[] nums=new int[]{4,3,2,7,8,2,3,1};
		List<Integer> list=f.findDuplicates(nums);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}

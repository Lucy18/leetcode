package leetcode;

import java.util.Arrays;

public class Set_Mismatch_645 {

	public int[] findErrorNums(int[] nums) {
		int[] result=new int[2];
		for(int i=0;i<nums.length;i++){
			int number=Math.abs(nums[i]);
			if(nums[number-1]>=0){
				nums[number-1]=-nums[number-1];
			}
			else{
				result[0]=number;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				result[1]=i+1;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set_Mismatch_645 s=new Set_Mismatch_645();
		int[] nums=new int[]{2,2};
		System.out.println(Arrays.toString(s.findErrorNums(nums)));
	}

}

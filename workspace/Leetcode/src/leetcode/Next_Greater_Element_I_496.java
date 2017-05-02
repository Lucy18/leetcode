package leetcode;

import java.util.Arrays;

public class Next_Greater_Element_I_496 {

	public int findIt(int[] nums,int num){
		boolean isFind=false;
		for(int i=0;i<nums.length;i++){
			if(isFind==false){
				if(nums[i]==num){
					isFind=true;
					continue;
				}
				else{
					continue;
				}
			}
			else{
				if(nums[i]>num){
					return nums[i];
				}
			}
		}
		return -1;
	}
	
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] result=new int[findNums.length];
		for(int i=0;i<findNums.length;i++){
			result[i]=findIt(nums, findNums[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Next_Greater_Element_I_496 n=new Next_Greater_Element_I_496();
		int[] findNums1=new int[]{4,1,2};
		int[] nums1=new int[]{1,3,4,2};
		System.out.println(Arrays.toString(n.nextGreaterElement(findNums1, nums1)));
		int[] findNums2=new int[]{2,4};
		int[] nums2=new int[]{1,2,3,4};
		System.out.println(Arrays.toString(n.nextGreaterElement(findNums2, nums2)));
	}

}

package leetcode;

import java.util.Arrays;

public class Next_Greater_Element_II_503 {

	public int[] nextGreaterElements(int[] nums) {
		int nextPointer=0;
		int n=nums.length;
		int[] result=new int[n];
		for(int i=0;i<n;i++){
			boolean isFind=false;
			int count=0;
			nextPointer=(i+1)%n;
			while(count<=n-1){
				if(nums[nextPointer]>nums[i]){
					result[i]=nums[nextPointer];
					isFind=true;
					break;
				}
				else{
					count++;
					nextPointer=(nextPointer+1)%n;
				}
			}
			if(isFind==false){
				result[i]=-1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Next_Greater_Element_II_503 n=new Next_Greater_Element_II_503();
		int[] nums=new int[]{1,2,1};
		System.out.println(Arrays.toString(n.nextGreaterElements(nums)));
	}

}

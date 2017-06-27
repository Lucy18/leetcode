package leetcode;

import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {

	public int[] productExceptSelf(int[] nums) {
		int length=nums.length;
		int[] result=new int[length];
		int[] leftProduct=new int[length];//每个leftProduct[i]里存nums[0]~nums[i-1]的乘积
		int[] rightProduct=new int[length];//每个rightProduct[i]里存nums[i+1]~nums[length-1]的乘积		
		leftProduct[0]=1;
		for(int i=1;i<length;i++){
			leftProduct[i]=leftProduct[i-1]*nums[i-1];
		}
		rightProduct[length-1]=1;
		for(int i=length-2;i>=0;i--){
			rightProduct[i]=rightProduct[i+1]*nums[i+1];
		}
		for(int i=0;i<length;i++){
			result[i]=leftProduct[i]*rightProduct[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_of_Array_Except_Self_238 p=new Product_of_Array_Except_Self_238();
		int[] nums=new int[]{1,2,3,4};
		System.out.println(Arrays.toString(p.productExceptSelf(nums)));
	}

}

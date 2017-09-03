package leetcode;

import java.util.Arrays;

public class Beautiful_Arrangement_II_667 {

	public int[] constructArray(int n, int k) {
		int[] result=new int[n];
		int low=1;
		int high=n;
		int isLowCase=1;
		int i=0;
		for(i=0;i<k;i++){//算 前k个数
			if(isLowCase==1){
				result[i]=low;
				low++;
			}
			else{
				result[i]=high;
				high--;
			}
			isLowCase=1-isLowCase;
		}
		//把 isLowCase 恢复到第k个数的情况 (在i循环中最后被反转了的)
		isLowCase=1-isLowCase;
		
		if(isLowCase==1){
			for(;i<n;i++){
				result[i]=low;
				low++;
			}
		}
		else{
			for(;i<n;i++){
				result[i]=high;
				high--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beautiful_Arrangement_II_667 b=new Beautiful_Arrangement_II_667();
		System.out.println(Arrays.toString(b.constructArray(9, 5)));
	}
}

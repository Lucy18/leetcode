package leetcode;

import java.util.ArrayList;

public class Maximum_Swap_670 {

	public int maximumSwap(int num) {
		ArrayList<Integer> digitsTmp=new ArrayList<Integer>();
		int tmpNum=num;
		while(tmpNum>=1){
			digitsTmp.add(tmpNum%10);
			tmpNum=tmpNum/10;
		}
		int n=digitsTmp.size();
		int[] digits=new int[n];
		for(int i=n-1;i>=0;i--){
			digits[n-1-i]=digitsTmp.get(i);
		}
		helper(digits,0,n);
		int result=0;
		for(int i=0;i<n;i++){
			result=result*10;
			result+=digits[i];
		}
		return result;
	}
	
	public void helper(int[] digits,int beginIndex,int n){
		if(beginIndex==n){
			return;
		}
		int maxDigit=digits[beginIndex];
		int max_index=beginIndex;
		for(int i=beginIndex;i<n;i++){
			if(digits[i]>=maxDigit){
				maxDigit=digits[i];
				max_index=i;
			}
		}
		if(maxDigit==digits[beginIndex]){
			helper(digits, beginIndex+1, n);
		}
		else{
			int tmp=digits[beginIndex];
			digits[beginIndex]=maxDigit;
			digits[max_index]=tmp;
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Swap_670 m=new Maximum_Swap_670();
		System.out.println(m.maximumSwap(9973));
	}

}

package leetcode;

import java.util.Arrays;

public class Plus_One_66 {

	public int[] plusOne(int[] digits) {
		int add=1;
		for(int i=digits.length-1;i>=0;i--){
			if(digits[i]==9){
				digits[i]=0;
			}
			else{
				digits[i]+=1;
				add=0;
				break;
			}
		}
		if(add==1){
			int[] newDigits=new int[digits.length+1];
			newDigits[0]=1;
			for(int i=0;i<digits.length;i++){
				newDigits[i+1]=digits[i];
			}
			return newDigits;
		}
		else{
			return digits;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plus_One_66 p=new Plus_One_66();
		int[] nums=new int[]{9,9};
		System.out.println(Arrays.toString(p.plusOne(nums)));
	}

}

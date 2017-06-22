package leetcode;

import java.util.Arrays;

public class Move_Zeroes_283 {

	public void moveZeroes(int[] nums) {
		int length=nums.length;
		int shuPointer=0;
		int zeroPointer=0;
		while (shuPointer<length && zeroPointer<length) {
			while (zeroPointer<length&&nums[zeroPointer] != 0) {
				zeroPointer++;
			}
			shuPointer = zeroPointer + 1;
			while (shuPointer<length&&nums[shuPointer] == 0) {
				shuPointer++;
			}
			if(shuPointer<length && zeroPointer<length){
				nums[zeroPointer] = nums[shuPointer];
				nums[shuPointer] = 0;
			}			
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Move_Zeroes_283 m=new Move_Zeroes_283();
		int[] a=new int[]{0, 1, 0, 3, 12};
		m.moveZeroes(a);
		System.out.println(Arrays.toString(a));
	}

}

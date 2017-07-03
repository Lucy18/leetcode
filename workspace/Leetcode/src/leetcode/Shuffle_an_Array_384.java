package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Shuffle_an_Array_384 {

	int[] oriNums;
	int n;
	Random random=new Random();
	
	public Shuffle_an_Array_384(int[] nums) {
		oriNums=nums.clone();
		n=nums.length;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return oriNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if(n==0){
			return new int[]{};
		}
		int[] result=new int[n];
		HashSet<Integer> hashSet=new HashSet<Integer>();
		int pointer=0;
		while(pointer<n){
			int index=random.nextInt(n);
			while(hashSet.contains(index)){
				index=random.nextInt(n);
			}
			hashSet.add(index);
			result[pointer]=oriNums[index];
			pointer++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,2,3};
		Shuffle_an_Array_384 s=new Shuffle_an_Array_384(nums);
		System.out.println(Arrays.toString(s.reset()));
		System.out.println(Arrays.toString(s.shuffle()));
	}

}

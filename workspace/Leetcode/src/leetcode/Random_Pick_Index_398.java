package leetcode;

import java.util.Random;

public class Random_Pick_Index_398 {

	int[] nums;
	Random random;
	
	public Random_Pick_Index_398(int[] nums){
		this.nums=nums;
		random=new Random();
	}

    
    public int pick(int target) {
    	int count=0;
    	int resultIndex=-1;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==target){
        		count++;
        		int r=random.nextInt(count);
            	if(r==count-1){
            		resultIndex=i;
            	}
        	}      	
        }
        return resultIndex;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,2,3,3,3};
		Random_Pick_Index_398 r=new Random_Pick_Index_398(nums);
		System.out.println(r.pick(3));
	}

}

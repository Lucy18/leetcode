package leetcode;

public class Find_the_Duplicate_Number_287 {

	public int findDuplicate(int[] nums) {
		int fast=0;
		int slow=0;
		while(true){
			slow=nums[slow];
			fast=nums[fast];fast=nums[fast];
		    if(slow==fast){
		    	break;
		    }
		}
		int pointer1=0;
		int pointer2=slow;
		while(pointer1!=pointer2){
			pointer1=nums[pointer1];
			pointer2=nums[pointer2];
		}
		return pointer1;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_the_Duplicate_Number_287 f=new Find_the_Duplicate_Number_287();
		int[] nums=new int[]{1,2,3,2};
		System.out.println(f.findDuplicate(nums));
	}

}

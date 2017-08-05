package leetcode;

public class Subarray_Sum_Equals_K_560 {

	public int subarraySum(int[] nums, int k) {
		int count=0;		
		for(int begin=0;begin<nums.length;begin++){
			int sum=0;
			for(int end=begin;end<nums.length;end++){
				sum+=nums[end];
				if(sum==k){
					count++;
				}
			}
		}	
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subarray_Sum_Equals_K_560 s=new Subarray_Sum_Equals_K_560();
		int[] nums=new int[]{-1,-1,1};
		System.out.println(s.subarraySum(nums, 0));
	}

}

package leetcode;

public class Maximum_Subarray_53 {

	public int maxSubArray(int[] nums) {
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<nums.length;i++){
			if(sum<=0){
				sum=nums[i];
			}
			else{
				sum=sum+nums[i];
			}
			if(sum>maxSum){
				maxSum=sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Subarray_53 m=new Maximum_Subarray_53();
		int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray(nums));
	}

}

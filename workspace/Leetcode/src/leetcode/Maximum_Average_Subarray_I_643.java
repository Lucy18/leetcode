package leetcode;

public class Maximum_Average_Subarray_I_643 {

	public double findMaxAverage(int[] nums, int k) {
		int sum=0;
		for(int i=0;i<k;i++){
			sum+=nums[i];
		}
		int maxSum=sum;
		int begin=0;int end=k;
		for(;end<nums.length;end++){
			sum-=nums[begin];
			sum+=nums[end];
			begin++;
			if(sum>maxSum){
				maxSum=sum;
			}
		}
		return (double)maxSum/k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Average_Subarray_I_643 m=new Maximum_Average_Subarray_I_643();
		int[] nums=new int[]{1,12,-5,-6,50,3};
		System.out.println(m.findMaxAverage(nums, 4));
	}

}

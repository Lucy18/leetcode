package leetcode;

public class Target_Sum_494 {

	int count;
	public int findTargetSumWays(int[] nums, int S) {
		int n=nums.length;
		getSum(nums, 0, 0, n, S);
		return count;
	}
	
	public void getSum(int[] nums,int index,int sum,int n,int S){
		if(index==n-1){
			if((sum+nums[n-1])==S){
				count++;
			}
			if((sum-nums[n-1])==S){
				count++;
			}
			return;
		}
		getSum(nums, index+1, sum+nums[index], n, S);	
		getSum(nums, index+1, sum-nums[index], n, S);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target_Sum_494 t=new Target_Sum_494();
		int[] nums=new int[]{1,1,1,1,1};
		System.out.println(t.findTargetSumWays(nums, 3));
	}

}

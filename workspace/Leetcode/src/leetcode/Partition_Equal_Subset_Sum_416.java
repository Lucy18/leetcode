package leetcode;

public class Partition_Equal_Subset_Sum_416 {

	public boolean canPartition(int[] nums) {
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		if(sum%2==1){
			return false;
		}
		int target=sum/2;
		//dp[i][j]存储：0~i中 是否存在子集 使得和为j
		boolean[][] dp=new boolean[nums.length][target+1];
		for(int i=0;i<nums.length;i++){
			dp[i][0]=true;//target为0，肯定是true
		}
		
		//为了防止nums是类似于[100]的情形
		if(nums[0]<=target){
			dp[0][nums[0]]=true;
		}	
		for(int i=1;i<nums.length;i++){
			for(int j=1;j<=target;j++){
				//如果0~i-1中存在子集使得 和为j，那么0~i中也存在
				//如果0~i-1中不存在子集使得 和为 j
				//但是0~i-1中存在子集使得和为 j-nums[i],那么0~i的和就可以是j
				if(j>=nums[i]){
					dp[i][j]= dp[i-1][j] || dp[i-1][j-nums[i]];
				}
				else{
					dp[i][j]= dp[i-1][j];
				}
			}
		}
		return dp[nums.length-1][target];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition_Equal_Subset_Sum_416 p=new Partition_Equal_Subset_Sum_416();
//		int[] nums=new int[]{3, 3, 3, 4, 5};
//		int[] nums=new int[]{2,2,3,3,6,6,8};
		int[] nums=new int[]{100};
		System.out.println(p.canPartition(nums));
	}

}

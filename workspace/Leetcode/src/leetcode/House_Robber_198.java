package leetcode;

public class House_Robber_198 {

	public int rob(int[] nums) {
		int n=nums.length;
		if(n==0){
			return 0;
		}
		//dp[i]:存储i~num.length能偷的最大钱
		int[] dp=new int[n+1];
		dp[n]=0;
		dp[n-1]=nums[n-1];
		for(int i=n-2;i>=0;i--){
			//不偷i，再从i+1开始偷，或者偷i，再从i+2开始偷
			dp[i]=Math.max(dp[i+1], nums[i]+dp[i+2]);
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House_Robber_198 h=new House_Robber_198();
		int[] nums=new int[]{10,2,3,1};
		System.out.println(h.rob(nums));
	}

}

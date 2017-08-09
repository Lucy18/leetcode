package leetcode;

public class Climbing_Stairs_70 {

	public int climbStairs(int n) {
		if(n == 1 || n == 2){
			return n;
		}
		int[] dp=new int[n+1];
		dp[1]=1;dp[2]=2;
		for(int i=3;i<=n;i++){
			//相当于在dp[i-1]的每个情况上加上1步
			//和在dp[i-2]的每个情况上加上2步
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Climbing_Stairs_70 c=new Climbing_Stairs_70();
		System.out.println(c.climbStairs(24));
	}

}

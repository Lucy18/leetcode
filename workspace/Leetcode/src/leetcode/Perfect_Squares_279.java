package leetcode;

public class Perfect_Squares_279 {

	public int numSquares(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		int square=2;
		for(int i=2;i<=n;i++){
			if(i<square*square){
				dp[i]=Integer.MAX_VALUE;
				for(int sq=1;sq<=square-1;sq++){
					dp[i]=Math.min(dp[i], 1+dp[i-sq*sq]);
				}				
			}
			else{ //i=square*square
				square++;
				dp[i]=1;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perfect_Squares_279 p=new Perfect_Squares_279();
		System.out.println(p.numSquares(13));
	}

}

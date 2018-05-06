package leetcode;

public class Domino_and_Tromino_Tiling_790 {

	public int numTilings(int N) {
		int mod=1000000007;
	    long[] dp=new long[1001];
	    dp[1]=1;
	    dp[2]=2;
	    dp[3]=5;
	    for(int i=4;i<=N;++i){
	        dp[i]=2*dp[i-1]+dp[i-3]; 
	        dp[i]=dp[i]%mod;
	    }
	    return (int)dp[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domino_and_Tromino_Tiling_790 d=new Domino_and_Tromino_Tiling_790();
		System.out.println(d.numTilings(30));
	}

}

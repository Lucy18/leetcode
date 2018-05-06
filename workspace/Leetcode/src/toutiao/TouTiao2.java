package toutiao;

import java.util.Scanner;

public class TouTiao2 {

	public int minOperation(int n){
		int[][] dp=new int[n+1][2];
		dp[1]=new int[]{0,1};
		dp[2]=new int[]{1,1};
		dp[3]=new int[]{2,1};
		for(int i=4;i<=n;i++){
			int minCount=Integer.MAX_VALUE;
			int m=0;
			for(int j=i-1;j>=1;j--){
				if((i-j)%dp[j][1]==0){
					int c=(i-j)/dp[j][1];
					if(dp[j][0]+c<minCount){
						minCount=dp[j][0]+c;
						m=dp[j][1];
					}	
				}			
				if(i==(j+j)){
					if(dp[j][0]+1<minCount){
						minCount=dp[j][0]+1;
						m=j;
					}		
				}
			}
			dp[i]=new int[]{minCount,m};
		}
		return dp[n][0];
	}
	
	public static void main(String[] args) {
		TouTiao2 t=new TouTiao2();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(t.minOperation(n));
		in.close();
	}

}

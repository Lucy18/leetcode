package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

	public int maxProfit(int[] prices) {
		int n=prices.length;
		if(n==0){
			return 0;
		}
		int[] dp=new int[n];
		dp[n-1]=0;		
		for(int begin=n-2;begin>=0;begin--){
			int maxCount=0;
			for(int end=begin+1;end<n;end++){
				int count=0;
				if(prices[end]<=prices[begin]){
					count=dp[end];
				}
				else{
					if(end+2<n){
						count=prices[end]-prices[begin]+dp[end+2];
					}
					else{
						count=prices[end]-prices[begin];
					}
				}
				if(count>maxCount){
					maxCount=count;
				}
			}
			dp[begin]=maxCount;
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 b=new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309();
		int[] prices=new int[]{2,1,4};
		System.out.println(b.maxProfit(prices));
	}

}

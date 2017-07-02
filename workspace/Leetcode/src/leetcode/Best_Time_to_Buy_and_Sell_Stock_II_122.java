package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

	public int maxProfit(int[] prices) {
		int n=prices.length;
		int profit=0;
		int buyPointer=0;
		int sellPointer=1;
		while (sellPointer < n) {
			while (sellPointer < n && prices[sellPointer] <= prices[buyPointer]) {
				buyPointer++;
				sellPointer++;
			}
			while (sellPointer + 1 < n && prices[sellPointer + 1] >= prices[sellPointer]) {
				sellPointer++;
			}
			if(sellPointer<n){
				profit += (prices[sellPointer] - prices[buyPointer]);
			}			
			buyPointer = sellPointer + 1;
			sellPointer = sellPointer + 2;
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Best_Time_to_Buy_and_Sell_Stock_II_122 b=new Best_Time_to_Buy_and_Sell_Stock_II_122();
		int[] prices=new int[]{2,1};
		System.out.println(b.maxProfit(prices));
	}

}

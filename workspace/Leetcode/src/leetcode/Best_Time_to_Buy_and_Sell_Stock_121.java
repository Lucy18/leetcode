package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

	public int maxProfit(int[] prices) {
		if(prices.length==0){
			return 0;
		}
		int lowest=prices[0];
		int highest=prices[0];
		int maxProfit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>highest){
				highest=prices[i];
				if(highest-lowest>maxProfit){
					maxProfit=highest-lowest;
				}				
			}
			else if(prices[i]<lowest){
				lowest=prices[i];
				highest=lowest;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Best_Time_to_Buy_and_Sell_Stock_121 b=new Best_Time_to_Buy_and_Sell_Stock_121();
		int[] prices=new int[]{3,2,6,5,0,3};
		System.out.println(b.maxProfit(prices));
	}

}

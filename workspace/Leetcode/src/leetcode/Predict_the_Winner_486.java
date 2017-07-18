package leetcode;

public class Predict_the_Winner_486 {

	public boolean PredictTheWinner(int[] nums) {
		int number=winner(nums, 0, nums.length-1, 1);
		if(number>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int winner(int[] nums,int low,int high,int isPlayer1Turn){
		if(low==high){
				return isPlayer1Turn*nums[low];
		}
		int pickFirst=isPlayer1Turn*nums[low]+winner(nums, low+1, high, -isPlayer1Turn);
		int pickLast=isPlayer1Turn*nums[high]+winner(nums, low, high-1, -isPlayer1Turn);
		int max=0;
		if(isPlayer1Turn==1){
			max=Math.max(pickFirst, pickLast);
		}
		else{
			max=Math.min(pickFirst, pickLast);//如果是player2的turn，是希望player1获取利益最少的
		}
		return max;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predict_the_Winner_486 p=new Predict_the_Winner_486();
		int[] nums=new int[]{1,5,233,7};
		System.out.println(p.PredictTheWinner(nums));
	}

}

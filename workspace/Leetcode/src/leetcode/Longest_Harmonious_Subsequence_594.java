package leetcode;

import java.util.HashMap;

public class Longest_Harmonious_Subsequence_594 {

	public int findLHS(int[] nums) {
		if(nums.length<=1){
			return 0;
		}		
		//map中存储某个数出现了多少次
		HashMap<Integer, Integer> preCount=new HashMap<Integer, Integer>();
		int maxLength=0;
		for(int i=0;i<nums.length;i++){
			int number=nums[i];
			int numberCount=preCount.getOrDefault(number, 0);
			//拿到number-1和number+1迄今为止出现的次数
			int numberMinus1Count=preCount.getOrDefault(number-1, 0);
			int numberPlus1Count=preCount.getOrDefault(number+1, 0);
			if(numberMinus1Count!=0 || numberPlus1Count!=0){
				int nowMax=1+numberCount+Math.max(numberMinus1Count, numberPlus1Count);
				if(nowMax>maxLength){
					maxLength=nowMax;
				}
			}		
			preCount.put(number, numberCount+1);
		}
		return maxLength;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Longest_Harmonious_Subsequence_594 l=new Longest_Harmonious_Subsequence_594();
		int[] nums=new int[]{1,1,1,1};
		System.out.println(l.findLHS(nums));
	}
}

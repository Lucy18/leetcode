package leetcode;

public class Longest_Increasing_Subsequence_300 {

	public int lengthOfLIS(int[] nums) {
		int maxLength=0;
		int[] DP=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			DP[i]=1;
			for(int j=0;j<i;j++){
				if(nums[j]<nums[i]){
					DP[i]=Math.max(DP[i],DP[j]+1);
				}
			}
			if(DP[i]>maxLength){
				maxLength=DP[i];
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Increasing_Subsequence_300 l=new Longest_Increasing_Subsequence_300();
		int[] nums=new int[]{10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(l.lengthOfLIS(nums));
	}

}

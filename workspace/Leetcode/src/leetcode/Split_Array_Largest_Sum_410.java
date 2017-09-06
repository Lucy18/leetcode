package leetcode;

public class Split_Array_Largest_Sum_410 {

	public int splitArray(int[] nums, int m) {
		int[][] memo=new int[nums.length][m+1];
		return split(nums, 0, nums.length-1, m, memo);
	}
	
	public int split(int[] nums,int left,int right,int m,int[][] memo){
		if(memo[left][m]>0){
			return memo[left][m];
		}
		int result;
		if(m==1){
			result=0;
			for(int i=left;i<=right;i++){
				result+=nums[i];
			}
		}
		else{
			result=Integer.MAX_VALUE;
			int sum=0;
			for(int i=left;i<=right-1;i++){
				sum+=nums[i];
				int min=Math.max(sum, split(nums, i+1, right, m-1, memo));
				result=Math.min(result, min);
			}
		}
		memo[left][m]=result;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Split_Array_Largest_Sum_410 s=new Split_Array_Largest_Sum_410();
		int[] nums=new int[]{7,2,5,10,8};
		System.out.println(s.splitArray(nums, 2));
	}

}

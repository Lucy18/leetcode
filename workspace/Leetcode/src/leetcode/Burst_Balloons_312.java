package leetcode;

public class Burst_Balloons_312 {

	public int maxCoins(int[] nums) {
		int[][] memory=new int[nums.length][nums.length];
		return maxCoins(nums,0,nums.length-1,memory);
	}
	
	public int maxCoins(int[] nums,int left,int right,int[][] memory){
		if(left>right){
			return 0;
		}
		if(memory[left][right]>0){
			return memory[left][right];
		}
		int maxCoins=0;
		for(int i=left;i<=right;i++){
			int coins=getValue(nums, left-1)*getValue(nums, i)*getValue(nums, right+1)
					+maxCoins(nums,left,i-1,memory)+maxCoins(nums, i+1, right,memory);
			if(coins>maxCoins){
				maxCoins=coins;
			}
		}
		memory[left][right]=maxCoins;
		return maxCoins;
	}
	
	public int getValue(int[] nums,int index){
		if(index==-1||index==nums.length){
			return 1;
		}
		else{
			return nums[index];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Burst_Balloons_312 b=new Burst_Balloons_312();
		int[] nums=new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2};
		System.out.println(b.maxCoins(nums));
	}

}
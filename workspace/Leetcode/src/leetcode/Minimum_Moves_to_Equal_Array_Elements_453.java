package leetcode;

public class Minimum_Moves_to_Equal_Array_Elements_453 {

	public int minMoves(int[] nums) {
		//sum-min*len
		int sum=0;
		int min=nums[0];
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			min=min<nums[i]?min:nums[i];
		}
		return sum-min*nums.length;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Moves_to_Equal_Array_Elements_453 m=new Minimum_Moves_to_Equal_Array_Elements_453();
		int[] nums=new int[]{1,2,3};
		System.out.println(m.minMoves(nums));
	}

}


package leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

	public int findMin(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		for(int i=0;i<nums.length-1;i++){
			if(nums[i+1]<nums[i]){
				return nums[i+1];
			}
		}
		return nums[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Minimum_in_Rotated_Sorted_Array_II_154 f=new Find_Minimum_in_Rotated_Sorted_Array_II_154();
//		int[] nums=new int[]{1,3,3};
//		int[] nums=new int[]{3,1,1};
//		int[] nums=new int[]{3,1,3};
		int[] nums=new int[]{3,3,1,3};
		System.out.println(f.findMin(nums));
	}

}

package leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

	public int findMin(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int i=0;
		while(i+1<nums.length&&nums[i]<nums[i+1]){
			i++;
		}
		if(i+1==nums.length){//i一直遍历到最后都没有找到
			return nums[0];
		}
		else{//i满足nums[i]>nums[i+1]
			return nums[i+1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Minimum_in_Rotated_Sorted_Array_153 f=new Find_Minimum_in_Rotated_Sorted_Array_153();
		int[] nums=new int[]{4,5,6,7,0,1,2};
		System.out.println(f.findMin(nums));
	}

}

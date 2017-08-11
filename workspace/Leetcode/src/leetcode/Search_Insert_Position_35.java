package leetcode;

public class Search_Insert_Position_35 {

	public int searchInsert(int[] nums, int target) {
		int left=0;
		int right=nums.length;
		while(left<right){
			int mid=left+(right-left)/2;
			if(nums[mid]==target){
				return mid;
			}
			else if(nums[mid]>target){
				right=mid;
			}
			else{//nums[mid]<target
				left=mid+1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_Insert_Position_35 s=new Search_Insert_Position_35();
		int[] nums=new int[]{1};
		System.out.println(s.searchInsert(nums, 2));
	}

}

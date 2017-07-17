package leetcode;

public class Single_Element_in_a_Sorted_Array_540 {

	public int singleNonDuplicate(int[] nums) {
		int n=nums.length;
		for(int i=0;i*2+1<n;i++){
			int thisNumber=nums[i*2];
			int nextNumber=nums[i*2+1];
			if(thisNumber!=nextNumber){
				return thisNumber;
			}
		}
		return nums[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single_Element_in_a_Sorted_Array_540 s=new Single_Element_in_a_Sorted_Array_540();
		int[] nums=new int[]{3,3,7,7,10,11,11};
		System.out.println(s.singleNonDuplicate(nums));
	}

}

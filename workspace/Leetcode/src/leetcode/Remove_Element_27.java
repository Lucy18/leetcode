package leetcode;

public class Remove_Element_27 {

	public int removeElement(int[] nums, int val) {
		int pointer=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[pointer]=nums[i];
				pointer++;
			}
		}
		return pointer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_Element_27 r=new Remove_Element_27();
		int[] nums=new int[]{3,2,2,3};
		System.out.println(r.removeElement(nums, 3));
	}

}

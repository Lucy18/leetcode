package leetcode;

public class Single_Number_136 {

	public int singleNumber(int[] nums) {
		int num=0;
		for(int i=0;i<nums.length;i++){
			num=num^nums[i];
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single_Number_136 s=new Single_Number_136();
		int[] a=new int[]{1,2,3,1,3};
		System.out.println(s.singleNumber(a));
	}

}

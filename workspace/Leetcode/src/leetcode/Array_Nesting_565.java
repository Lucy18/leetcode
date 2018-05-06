package leetcode;

public class Array_Nesting_565 {

	public int arrayNesting(int[] nums) {
		int maxLength=-1;
		for(int firstIndex=0;firstIndex<=nums.length-1;firstIndex++){
			int length=0;
			while(nums[firstIndex]!=-1){
				length++;
				int firstTemp=nums[firstIndex];
				nums[firstIndex]=-1;
				firstIndex=firstTemp;
			}
			maxLength=maxLength>length?maxLength:length;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array_Nesting_565 a=new Array_Nesting_565();
		int[] b=new int[]{5,4,0,3,1,6,2};
		int[] b2=new int[]{5,4,0,3,1,6,4};
		System.out.println(a.arrayNesting(b2));
	}

}

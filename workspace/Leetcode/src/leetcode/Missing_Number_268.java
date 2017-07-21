package leetcode;

public class Missing_Number_268 {

	public int missingNumber(int[] nums) {
		int n=nums.length;
		int[] indexedNums=new int[n+1];
		for(int i=0;i<n;i++){
			int number=nums[i];
			indexedNums[number]=1;
		}
		for(int i=0;i<n+1;i++){
			if(indexedNums[i]==0){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Missing_Number_268 m=new Missing_Number_268();
		int[] nums=new int[]{0,1,3};
		System.out.println(m.missingNumber(nums));
	}

}

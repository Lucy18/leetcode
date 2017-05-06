package leetcode;

public class Max_Consecutive_Ones_485 {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max=0;
		for(int i=0;i<nums.length;i++){
			int thisMax=0;
			while(i<nums.length&&nums[i]==1){
				thisMax++;
				i++;
			}
			max=thisMax>max?thisMax:max;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max_Consecutive_Ones_485 m=new Max_Consecutive_Ones_485();
		int[] nums=new int[]{1,1,0,1,1,1};
		System.out.println(m.findMaxConsecutiveOnes(nums));
	}

}

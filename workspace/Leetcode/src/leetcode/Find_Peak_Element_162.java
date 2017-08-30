package leetcode;

public class Find_Peak_Element_162 {

	public int findPeakElement(int[] nums) {
		int n=nums.length;
		if(n==1){
			return 0;
		}
		int leftNeighbour=Integer.MIN_VALUE;
		int rightNeighbour=-1;
		for(int i=0;i<=n-2;i++){
			 rightNeighbour=nums[i+1];
			 if(nums[i]>leftNeighbour&&nums[i]>rightNeighbour){
				 return i;
			 }
			 leftNeighbour=nums[i];
		}
		if(leftNeighbour<nums[n-1]){
			return n-1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Peak_Element_162 f=new Find_Peak_Element_162();
		int[] nums=new int[]{1, 2, 3, 1};
		System.out.println(f.findPeakElement(nums));
	}

}

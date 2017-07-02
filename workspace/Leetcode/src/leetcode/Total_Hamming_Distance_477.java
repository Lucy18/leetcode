package leetcode;

public class Total_Hamming_Distance_477 {

	public int totalHammingDistance(int[] nums) {
		int n=nums.length;
		int total=0;
		for(int i=0;i<32;i++){
			int countOf_1=0;
			for(int j=0;j<n;j++){
				countOf_1 += ( (nums[j]>>i) & 1 );
			}
			total+=countOf_1*(n-countOf_1);
		}
		return total;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Total_Hamming_Distance_477 t=new Total_Hamming_Distance_477();
		int[] nums=new int[]{4, 14, 2};
		System.out.println(t.totalHammingDistance(nums));
	}

}

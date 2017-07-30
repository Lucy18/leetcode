package leetcode;

public class Single_Number_II_137 {

	public int singleNumber(int[] nums) {
		int result = 0;
		int[] bitCounts = new int[32];
		for (int i = 0; i < 32; i++) {
			//Find sum of set bits at ith position in all
			for (int num : nums) {
				int x = num >> i;
				if ((x & 1) == 1) {
					bitCounts[i]++;
				}
			}
			// The bits with sum not multiple of 3, are the
		    // bits of element with single occurrence.
			if (bitCounts[i] % 3 == 1) {
				result = result | (1 << i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single_Number_II_137 s=new Single_Number_II_137();
		int[] nums=new int[]{3,3,3,4,4,4,1};
		System.out.println(s.singleNumber(nums));
	}

}

package leetcode;

public class Valid_Triangle_Number_611 {

	public int triangleNumber(int[] nums) {
		int[] map=new int[1001];
		for(int i=0;i<nums.length;i++){
			map[nums[i]]++;
		}
		int count=0;
		for(int i=0;i<nums.length-2;i++){
			map[nums[i]]--;
			for(int j=i+1;j<nums.length-1;j++){
				map[nums[j]]--;
				//只找j后面的数
				int one=nums[i];
				int two=nums[j];
				int min=Math.abs(one-two)+1;
				int max=one+two-1;
				for(int k=min;k<=max;k++){
					count+=map[k];
				}
			}
			//又加回去
			for(int j=i+1;j<nums.length-1;j++){
				map[nums[j]]++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Triangle_Number_611 v=new Valid_Triangle_Number_611();
		int[] nums=new int[]{2,2,3,4};
		System.out.println(v.triangleNumber(nums));
	}

}

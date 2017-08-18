package leetcode;

import java.util.HashMap;

public class Contiguous_Array_525 {

	public int findMaxLength(int[] nums) {
		int n=nums.length;
		if(n<2){
			return 0;
		}
		int maxLength=0;
		//map存储[0,i]算出的和
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int sum=0;
		map.put(0, -1);
		for(int i=0;i<n;i++){
			if(nums[i]==1){
				sum+=1;
			}
			else{
				sum+=-1;
			}
			//sum-sum=0
			if(map.get(sum)!=null){
				int length=i-map.get(sum);
				if(length>maxLength){
					maxLength=length;
				}
			}
			else {
				map.put(sum,i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contiguous_Array_525 c=new Contiguous_Array_525();
//		int[] nums=new int[]{0,0,0,1,1,1,0};
		int[] nums=new int[]{0,0,1,0,0,0,1,1};
		System.out.println(c.findMaxLength(nums));
	}

}

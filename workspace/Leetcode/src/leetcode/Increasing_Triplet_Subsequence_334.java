package leetcode;

public class Increasing_Triplet_Subsequence_334 {

	public boolean increasingTriplet(int[] nums) {	
		if(nums.length<3){
			return false;
		}
		Integer min=null;//最小元素
		Integer nextMin=null;//索引在最小元素后面的第二小元素
		for(int i=0;i<nums.length;i++){
			if(min==null){
				min=nums[i];
			}
			else if(nextMin==null){
				if(nums[i]<min){
					min=nums[i];
				}
				else if(nums[i]>min){
					nextMin=nums[i];
				}
				//nums[i]==min，直接continue;
			}
			else{
				if(nums[i]>nextMin){
					return true;
				}
				else{
					if(nums[i]<min){
						min=nums[i];
					}
					// min＜nums[i]＜nextMin
					else if(nums[i]>min&&nums[i]<nextMin){
						nextMin=nums[i];
					}
					//nums[i]==min||nums[i]==nextMin，直接continue;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Increasing_Triplet_Subsequence_334 i=new Increasing_Triplet_Subsequence_334();
		int[] nums=new int[]{1,0,2,-1,3};
		System.out.println(i.increasingTriplet(nums));
	}

}

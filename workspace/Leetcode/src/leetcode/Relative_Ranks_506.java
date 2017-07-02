package leetcode;

import java.util.Arrays;

public class Relative_Ranks_506 {

	public String[] findRelativeRanks(int[] nums) {
		int n=nums.length;
		if(n==1){
			return new String[]{"Gold Medal"};
		}
		if(n==2){
			if(nums[0]>nums[1]){
				return new String[]{"Gold Medal","Silver Medal"};
			}
			else{
				return new String[]{"Silver Medal","Gold Medal"};
			}
		}
		int[] index=new int[n];
		for(int i=0;i<n;i++){
			index[i]=i;
		}
		quickSort(nums, index, 0, n-1);
		String[] result=new String[n];
		result[index[0]]="Gold Medal";//index前3位记录了排名前三位的index
		result[index[1]]="Silver Medal";
		result[index[2]]="Bronze Medal";
		for(int i=3;i<n;i++){
			result[index[i]]=(i+1)+"";
		}
		return result;
	}
	
	public void quickSort(int[] nums,int[] index,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			int pivot=nums[low];
			int tmp=index[low];
			while(low<high){
				while(low<high&&nums[high]<=pivot){
					high--;
				}
				nums[low]=nums[high];
				index[low]=index[high];
				while(low<high&&nums[low]>=pivot){
					low++;
				}
				nums[high]=nums[low];
				index[high]=index[low];
			}
			nums[low]=pivot;
			index[low]=tmp;
			quickSort(nums, index, left, low-1);
			quickSort(nums, index, low+1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Relative_Ranks_506 r=new Relative_Ranks_506();
		int[] nums=new int[]{1};
		System.out.println(Arrays.toString(r.findRelativeRanks(nums)));
	}

}

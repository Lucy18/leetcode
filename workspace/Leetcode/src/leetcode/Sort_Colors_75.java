package leetcode;

import java.util.Arrays;

public class Sort_Colors_75 {

	public void sortColors(int[] nums) {
		int low=0;
		int high=nums.length-1;
		while(low<high){
			while(low<high&&nums[low]==0){
				low++;
			}
			while(low<high&&nums[high]==2){
				high--;
			}
			if(nums[low]==2){
				swap(nums, low, high);
				high--;
			}
			else if(nums[high]==0){
				swap(nums, low, high);
				low++;
			}
			else{//nums[low]=1&&nums[high]=1
				if(low<high){
					int i=low+1;
					while(i<high&&nums[i]==1){
						i++;
					}
					if(i<high){
						if(nums[i]==0){
							swap(nums, low, i);
							low++;
						}
						else{//nums[i]==2
							swap(nums, high, i);
							high--;
						}
					}
					else{//i一直到high都没发现有!=1的数
						return;
					}
				}
			}		
		}	
	}
	
	public void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort_Colors_75 s=new Sort_Colors_75();
		int[] nums=new int[]{0,0,1,2,0,1,2,2};
		s.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}

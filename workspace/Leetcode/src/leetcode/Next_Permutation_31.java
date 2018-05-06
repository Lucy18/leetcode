package leetcode;

public class Next_Permutation_31 {

	public void nextPermutation(int[] nums) {
		if(nums==null||nums.length==0){
			return;
		}
		int index=nums.length-2;
		while(index>=0){
			if(nums[index+1]>nums[index]){
				break;
			}
			index--;
		}
		int low=-1;
		if(index==-1){
			low=0;
		}
		else{
			int biggerIndex=index+1;
			for(int i=biggerIndex+1;i<nums.length;i++){
				if(nums[i]>nums[index]&&nums[i]<nums[biggerIndex]){
					biggerIndex=i;
				}
			}
			int tmp=nums[index];
			nums[index]=nums[biggerIndex];
			nums[biggerIndex]=tmp;
			low=index+1;
		}
		sort(nums,low,nums.length-1);
	}
		
	public void sort(int[] nums,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			int pivot=nums[low];
			while(low<high){
				while(low<high&&nums[high]>=pivot){
					high--;
				}
				if(low<high){
					nums[low]=nums[high];
					low++;
				}	
				while(low<high&&nums[low]<=pivot){
					low++;
				}
				if(low<high){
					nums[high]=nums[low];
					high--;
				}					
			}
			nums[low]=pivot;
			sort(nums, left, low-1);
			sort(nums, low+1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Next_Permutation_31 n=new Next_Permutation_31();
		int[] nums=new int[]{1,1,5};
		int[] nums2=new int[]{5,4,7,5,3,2};
		n.nextPermutation(nums2);
		for(int i=0;i<nums2.length;i++){
			System.out.print(nums2[i]+",");
		}
	}

}

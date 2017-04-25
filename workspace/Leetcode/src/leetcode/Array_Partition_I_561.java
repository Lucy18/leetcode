package leetcode;

public class Array_Partition_I_561 {
	
	public void quickSort(int[] list,int left,int right){
		if (left < right) {
			int pos = partition(list, left, right);
			quickSort(list, left, pos - 1);
			quickSort(list, pos + 1, right);
		}
	}
	
	public int partition(int[] list,int low,int high){
		int pos=list[low];
		while(low<high){
			while(list[high]>=pos&&low<high){high--;}
			if(low<high){
				list[low]=list[high];
				low++;
			}			
			while(list[low]<=pos&&low<high){low++;}
			if(low<high){
				list[high]=list[low];
				high--;
			}	
		}
		list[low]=pos;
		return low;
	}
	
	public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int sum=0;
        for(int i=0;i<nums.length/2;i++){
        	sum+=nums[i*2];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Array_Partition_I_561 a=new Array_Partition_I_561();
		int[] nums=new int[]{1,4,3,2};
	    System.out.println(a.arrayPairSum(nums));
	}
	
}

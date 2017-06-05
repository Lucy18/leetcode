package leetcode;

public class Minimum_Moves_to_Equal_Array_Elements_II_462 {

	public int minMoves2(int[] nums) {
		int result=0;
		int length=nums.length;
		int k=length/2;//看中位数的index索引
		//接下来就是找数组中第k大的元素是多少了
		int low=0;
		int high=length-1;
		int mid=sort(nums, low, high);
		while(mid!=k){		
			if(mid>k){
				high= mid-1;
				mid=sort(nums, low, high);
			}
			else{
				low=mid+1;
				mid=sort(nums, low, high);
			}
		}
		int theNumer=nums[k];
		for(int i=0;i<length;i++){
			result+=Math.abs(nums[i]-theNumer);
		}
		return result;
	}
	
	public int sort(int[] nums,int low,int high){
		int pivot=nums[low];
		while (low < high) {
			while (low < high && nums[high] >= pivot) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= pivot) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low]=pivot;
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Moves_to_Equal_Array_Elements_II_462 m=new Minimum_Moves_to_Equal_Array_Elements_II_462();
		int[] a=new int[]{1,0,0,8,6};
		System.out.println(m.minMoves2(a));
	}

}

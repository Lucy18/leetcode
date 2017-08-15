package leetcode;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		for(int i=0;i<nums.length;i++){
			if(queue.size()<k){
				queue.offer(nums[i]);
			}
			else{
				int kLargest=queue.peek();
				if(kLargest<nums[i]){
					queue.poll();
					queue.offer(nums[i]);
				}
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kth_Largest_Element_in_an_Array_215 k=new Kth_Largest_Element_in_an_Array_215();
		int[] nums=new int[]{3,2,1,5,6,4};
		System.out.println(k.findKthLargest(nums, 2));
	}

}

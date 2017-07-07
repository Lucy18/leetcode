package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Smallest_Range_632 {

	public int[] smallestRange(List<List<Integer>> nums) {
		int n=nums.size();
		//int[]三个元素的数组，分别存[value,k(位于第几个list),index(位于第k个list中的第index位)]
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		int max=Integer.MIN_VALUE;
		int minRange=Integer.MAX_VALUE;
		int minRange_min=Integer.MAX_VALUE;
		int minRange_max=Integer.MIN_VALUE;
		for(int i=0;i<nums.size();i++){
			int val=nums.get(i).get(0);
			max=Math.max(max, val);
			queue.offer(new int[]{val,i,0});
		}
		while (minRange != 0) {
			int[] now_min = queue.poll();//// now_min指当前queue中的最小元素
			if (max - now_min[0] < minRange) {
				minRange = max - now_min[0];
				minRange_min = now_min[0];
				minRange_max = max;
			}
			int k = now_min[1];
			int index = now_min[2];
			index += 1;
			if (index == nums.get(k).size()) {
				break;
			}
			int val = nums.get(k).get(index);
			if (val > max) {
				max = val;
			}
			queue.offer(new int[] { val, k, index });
		}
		
		return new int[]{minRange_min,minRange_max};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Smallest_Range_632 s=new Smallest_Range_632();
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(4);list1.add(10);list1.add(15);list1.add(24);list1.add(26);
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(0);list2.add(9);list2.add(12);list2.add(20);
		List<Integer> list3=new ArrayList<Integer>();
		list3.add(5);list3.add(18);list3.add(22);list3.add(30);
		List<List<Integer>> nums=new ArrayList<List<Integer>>();
		nums.add(list1);nums.add(list2);nums.add(list3);
		
//		List<Integer> list1=new ArrayList<Integer>();
//		list1.add(1);
//		List<Integer> list2=new ArrayList<Integer>();
//		list2.add(2);
//		List<Integer> list3=new ArrayList<Integer>();
//		list3.add(3);
//		List<Integer> list4=new ArrayList<Integer>();
//		list4.add(4);
//		List<Integer> list5=new ArrayList<Integer>();
//		list5.add(5);
//		List<Integer> list6=new ArrayList<Integer>();
//		list6.add(6);
//		List<Integer> list7=new ArrayList<Integer>();
//		list7.add(7);
//		List<List<Integer>> nums=new ArrayList<List<Integer>>();
//		nums.add(list1);nums.add(list2);nums.add(list3);nums.add(list4);nums.add(list5);nums.add(list6);nums.add(list7);
		System.out.println(Arrays.toString(s.smallestRange(nums)));
	}

}

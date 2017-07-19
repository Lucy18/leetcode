package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection_of_Two_Arrays_II_350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> intersect=new ArrayList<Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<nums1.length;i++){
			int count=map.getOrDefault(nums1[i], 0);
			count++;
			map.put(nums1[i], count);
		}
		for(int i=0;i<nums2.length;i++){
			int count=map.getOrDefault(nums2[i], 0);
			if(count==0){
				continue;
			}
			else{
				count--;
				intersect.add(nums2[i]);
				map.put(nums2[i], count);
			}
		}
		int[] result=new int[intersect.size()];
		for(int i=0;i<intersect.size();i++){
			result[i]=intersect.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intersection_of_Two_Arrays_II_350 i=new Intersection_of_Two_Arrays_II_350();
		int[] nums1=new int[]{1,2,2,1};
		int[] nums2=new int[]{2,2};
		int[] result=i.intersect(nums1, nums2);
		for(int j=0;j<result.length;j++){
			System.out.print(result[j]+" ");
		}
	}

}

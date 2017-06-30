package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection_of_Two_Arrays_349 {

	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length==0||nums2.length==0){
			return new int[]{};
		}
		int size=0;
		ArrayList<Integer> result=new ArrayList<Integer>();
		HashMap<Integer, Integer> map1=new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2=new HashMap<Integer, Integer>();//map2的存在是防止result中的值不唯一
		for(int i=0;i<nums1.length;i++){
			if(map1.get(nums1[i])==null){
				map1.put(nums1[i], 0);//map的value随便取值
			}
		}
		for(int i=0;i<nums2.length;i++){
			if(map2.get(nums2[i])!=null){
				continue;
			}
			if(map1.get(nums2[i])!=null){
				size++;
				result.add(nums2[i]);
				map2.put(nums2[i], 0);
			}
		}
		int[] theResult=new int[size];
		for(int i=0;i<size;i++){
			theResult[i]=result.get(i);
		}
		return theResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intersection_of_Two_Arrays_349 i=new Intersection_of_Two_Arrays_349();
		int[] nums1=new int[]{1,2,2,1};
		int[] nums2=new int[]{2,2};
		System.out.println(Arrays.toString(i.intersection(nums1, nums2)));
	}

}

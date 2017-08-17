package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Increasing_Subsequences_491 {

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set=new HashSet<List<Integer>>();
		HashMap<Integer, List<List<Integer>>> map=new HashMap<Integer, List<List<Integer>>>();
		for(int i=0;i<nums.length;i++){
			List<List<Integer>> list=helper(i, nums, map);
			for(List<Integer> tmp:list){
				if(tmp.size()>=2){
					if(!set.contains(tmp)){
						result.add(tmp);
						set.add(tmp);
					}					
				}
			}
		}
		return result;
	}
	
	//返回一定以某个index元素开头的序列集合
	public List<List<Integer>> helper(int index,int[] nums,
			HashMap<Integer, List<List<Integer>>> map){
		if(map.get(index)!=null){
			return map.get(index);
		}
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		int nextIndex=index+1;
		int count=1;
		//得到nums[index]数连续出现个数
		while(nextIndex<nums.length&&nums[nextIndex]==nums[index]){
			count++;
			nextIndex++;
		}
		for(int nowCount=1;nowCount<=count;nowCount++){
			List<Integer> tmp=new ArrayList<Integer>();
			for(int j=0;j<nowCount;j++){
				tmp.add(nums[index]);
			}
			result.add(tmp);
		}
		int prefixSize=result.size();
		while(nextIndex<nums.length){
			//得到下一个大于等于当前数的index
			while(nextIndex<nums.length&&nums[nextIndex]<nums[index]){
				nextIndex++;
			}
			if(nextIndex<nums.length){
				List<List<Integer>> nextList=helper(nextIndex, nums, map);
				for(int i=0;i<prefixSize;i++){
					List<Integer> prefix=result.get(i);
					for(List<Integer> postFix:nextList){
						List<Integer> tmp=new ArrayList<Integer>(prefix);
						tmp.addAll(postFix);
						result.add(tmp);
					}
				}
			}
			//得到下一个不等于nextIndex的数
			int i=nextIndex+1;
			while(i<nums.length&&nums[i]==nums[nextIndex]){
				i++;
			}
			nextIndex=i;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Increasing_Subsequences_491 i=new Increasing_Subsequences_491();
		int[] nums=new int[]{1,2,1,1};
		List<List<Integer>> result=i.findSubsequences(nums);
		for(List<Integer> list:result){
			for(Integer in:list){
				System.out.print(in+" ");
			}
			System.out.println();
		}
//		String s1="";
//		String s2="";
//		HashSet<String> set1=i.getList(s1);
//		System.out.println("-----------------");
//		HashSet<String> set2=i.getList(s2);
//		for(String s:set1){
//			if(!set2.contains(s)){
//				System.out.println(s);
//			}
//		}
	}
	
	HashSet<String> getList(String s){
		HashSet<String> r=new HashSet<String>();
		s=s.split("\\[\\[")[1];
		s=s.split("\\]\\]")[0];
		String[] ss=s.split("\\],\\[");
		for(int i=0;i<ss.length;i++){
			if(r.contains(ss[i])){
				System.out.println(ss[i]);
			}
			r.add(ss[i]);
		}
		return r;
	}

}

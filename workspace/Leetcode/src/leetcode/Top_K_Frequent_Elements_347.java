package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements_347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result=new ArrayList<Integer>();
		HashMap<Integer, Integer> num_frequency=new HashMap<Integer, Integer>();
		int maxFrequency=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			int frequency=num_frequency.getOrDefault(num, 0);		
			frequency++;
			num_frequency.put(num,frequency);
			maxFrequency=maxFrequency>frequency?maxFrequency:frequency;
		}
		String[] bucket=new String[maxFrequency+1];
		Iterator iter = num_frequency.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int num = (int)entry.getKey();
			int frequency = (int)entry.getValue();
			if(bucket[frequency]==null){
				bucket[frequency]=num+"";
			}
			else{
				bucket[frequency]=bucket[frequency]+","+num;
			}			
		}
		int theFrequency=maxFrequency;
		while(k>0){
			String theString=bucket[theFrequency];
			if(theString!=null){
				String[] splitWords=theString.split(",");
				for(int i=0;i<splitWords.length&&k>0;i++){
					result.add(Integer.parseInt(splitWords[i]));
					k--;
				}
			}			
			theFrequency--;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Top_K_Frequent_Elements_347 t=new Top_K_Frequent_Elements_347();
		int k=2;
		int[] nums=new int[]{1,2};
		List<Integer> list=t.topKFrequent(nums, k);
		for(Integer i:list){
			System.out.println(i);
		}
	}

}

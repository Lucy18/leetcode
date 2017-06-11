package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Single_Number_III_260 {

	public int[] singleNumber(int[] nums) {
		int[] result=new int[2];
		int pointer=0;			
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])==null){
				map.put(nums[i], 1);
			}
			else{
				map.put(nums[i], -1);
			}
		}
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			if((int)val==1){
				result[pointer]=(int)key;
				pointer++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single_Number_III_260 s=new Single_Number_III_260();
		int[] nums1=new int[]{-1139700704,-1653765433};
		System.out.println(Arrays.toString(s.singleNumber(nums1)));
	}

}

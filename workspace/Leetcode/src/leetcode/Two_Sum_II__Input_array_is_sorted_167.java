package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_II__Input_array_is_sorted_167 {

	public int[] twoSum(int[] numbers, int target) {
		int[] result=new int[2];
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.get(numbers[i])==null){
				map.put(numbers[i], i);
			}
		}
		for(int i=0;i<numbers.length;i++){
			int needNum=target-numbers[i];
			if(needNum==numbers[i]){
				result[0]=i+1;
				result[1]=i+2;
				break;
			}
			if(map.get(needNum)!=null){
				result[0]=i+1;//因为both index1 and index2 are not zero-based
				result[1]=map.get(needNum)+1;//所以index要加1
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Two_Sum_II__Input_array_is_sorted_167 t=new Two_Sum_II__Input_array_is_sorted_167();
		int[] nums=new int[]{0,0,3,4};
		int target=9;
		System.out.println(Arrays.toString(t.twoSum(nums, target)));
	}

}

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Distribute_Candies_575 {

	public int distributeCandies(int[] candies) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int length=candies.length;
		int halfLength=length/2;
		int count=0;
		for(int i=0;i<candies.length;i++){
			int theCandy=candies[i];
			if(map.get(theCandy)==null){
				count++;
				map.put(theCandy, 0);
			}
		}
		if(count>halfLength){
			return halfLength;
		}
		else{
			return count;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Distribute_Candies_575 d=new Distribute_Candies_575();
		int[] a=new int[]{1,1,2,3};
		System.out.println(d.distributeCandies(a));
	}

}

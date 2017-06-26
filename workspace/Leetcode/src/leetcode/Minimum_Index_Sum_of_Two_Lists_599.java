package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_Index_Sum_of_Two_Lists_599 {

	public String[] findRestaurant(String[] list1, String[] list2) {
		ArrayList<String> resultlist=new ArrayList<String>();
		int resultCount=0;
		int minSum=Integer.MAX_VALUE;
		int pointer1=0;
		int pointer2=0;
		for(pointer1=0;pointer1<list1.length;pointer1++){
			pointer2=0;
			if((pointer1+pointer2)>minSum){
				break;
			}
			while (pointer2 < list2.length && (pointer1 + pointer2) <= minSum) {
				if (list1[pointer1].equals(list2[pointer2])) {
					if((pointer1 + pointer2)<minSum){
						minSum=pointer1 + pointer2;
						resultCount=1;
						resultlist.clear();
						resultlist.add(list1[pointer1]);
					}
					else{//(pointer1 + pointer2)=minSum
						resultCount++;
						resultlist.add(list1[pointer1]);
					}
					break;
				} else {
					pointer2++;
				}
			}	
		}
		String[] result=new String[resultCount];
		for(int i=0;i<resultCount;i++){
			result[i]=resultlist.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Index_Sum_of_Two_Lists_599 m=new Minimum_Index_Sum_of_Two_Lists_599();
		String[] s1=new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] s2=new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		String[] s3=new String[]{"KFC","Burger King","Tapioca Express","Shogun"};
		System.out.println(Arrays.toString(m.findRestaurant(s1, s2)));
	}

}


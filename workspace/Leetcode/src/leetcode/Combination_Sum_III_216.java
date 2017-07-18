package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III_216 {

	List<List<Integer>> result=new ArrayList<List<Integer>>();
	int theK;
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		theK=k;
		int[] num=new int[k+1];
		combination(num, 0, k, n);
		return result;
	}
	
	public void combination(int[] num,int usedLow,int k,int n){
		if(k==1){
			if(n>usedLow&&n<=9){
				num[k]=n;
				addToList(num);			
			}
			return;
		}
		for(int i=usedLow+1;i<=9;i++){
			num[k]=i;
			combination(num, i, k-1, n-i);
		}
	}
	
	public void addToList(int[] num){
		List<Integer> list=new ArrayList<Integer>();
		int k=theK;
		while(k>=1){
			list.add(num[k]);
			k--;
		}
		result.add(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination_Sum_III_216 c=new Combination_Sum_III_216();
		List<List<Integer>> result=c.combinationSum3(2, 18);
		for(List<Integer> list:result){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}

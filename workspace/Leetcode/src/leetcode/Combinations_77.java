package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		helper(res, list, 1, n, k);
		return res;
	}
	
	public void helper(List<List<Integer>> res,
			List<Integer> list,int beginNum,int n,int k){
		if(list.size()==k){
			res.add(new ArrayList<>(list));
			return;
		}
		if(beginNum>n){
			return;
		}
		for(int i=beginNum;i<=n;i++){
			list.add(i);
			helper(res, list, i+1, n, k);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations_77 c=new Combinations_77();
		List<List<Integer>> res=c.combine(4, 2);
		for(List<Integer> list:res){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(numRows==0){
			return result;
		}
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		result.add(list);
		if(numRows==1){
			return result;
		}
		list=new ArrayList<Integer>();
		list.add(1);list.add(1);
		result.add(list);
		if(numRows==2){
			return result;
		}
		for(int i=3;i<=numRows;i++){
			list=new ArrayList<Integer>();
			list.add(1);
			List<Integer> pre=result.get(i-2);//第i-1个，就是index=i-2
			for(int pointer=0;pointer<i-2;pointer++){
				list.add(pre.get(pointer)+pre.get(pointer+1));
			}
			list.add(1);
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pascal_s_Triangle_118 p=new Pascal_s_Triangle_118();
		List<List<Integer>> result=p.generate(5);
		for(List<Integer> list:result){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}

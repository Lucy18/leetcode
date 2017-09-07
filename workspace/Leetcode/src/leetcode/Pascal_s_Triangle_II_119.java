package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_II_119 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list=new ArrayList<Integer>();
		if(rowIndex==0){
			list.add(1);
			return list;
		}
		list.add(1);list.add(1);
		for(int i=2;i<=rowIndex;i++){//第i行有i+1个数
			int tmp=1;	
			for(int j=1;j<i;j++){
				int sum=tmp+list.get(j);
				tmp=list.get(j);
				list.set(j, sum);
			}
			list.add(1);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pascal_s_Triangle_II_119 p=new Pascal_s_Triangle_II_119();
		List<Integer> list=p.getRow(3);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}

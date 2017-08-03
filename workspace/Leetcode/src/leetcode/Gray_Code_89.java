package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Gray_Code_89 {
	
	public List<Integer> grayCode(int n) {
		List<Integer> result=new ArrayList<Integer>();
		if(n==0){
			result.add(0);
			return result;
		}
		List<Integer> tmpList=grayCode(n-1);
		//加上前缀0，数字保持不变
		result.addAll(tmpList);
		//加上前缀1，用“或”操作来加上前缀1
		int mask=(1 << n-1);
		for(int i=tmpList.size()-1;i>=0;i--){
			int theNum=tmpList.get(i);
			result.add(theNum | mask);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gray_Code_89 g=new Gray_Code_89();
		List<Integer> list=g.grayCode(3);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}

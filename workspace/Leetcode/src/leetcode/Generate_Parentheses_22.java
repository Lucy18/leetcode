package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Generate_Parentheses_22 {

	HashMap<Integer, List<String>> map=new HashMap<Integer, List<String>>();
	
	public List<String> generateParenthesis(int n) {
		List<String> list=new ArrayList<String>();
		if(n==0){
			list.add("");
			return list;
		}
		if(n==1){
			list.add("()");
			return list;
		}
		if(map.get(n)!=null){
			return map.get(n);
		}
		HashSet<String> hashSet=new HashSet<String>();	
		List<String> n_1_Paenthesis=generateParenthesis(n-1);
		for(String s:n_1_Paenthesis){
			hashSet.add("("+s+")");
		}
		for(int left=1;left<=n-1;left++){
			List<String> left_Paenthesis=generateParenthesis(left);
			int right=n-left;
			List<String> right_Paenthesis=generateParenthesis(right);
			for(String ls:left_Paenthesis){
				for(String rs:right_Paenthesis){
					hashSet.add(ls+rs);
				}
			}
			
		}
				
		for(String s:hashSet){
			list.add(s);
		}
		map.put(n, list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generate_Parentheses_22 g=new Generate_Parentheses_22();
		List<String> list=g.generateParenthesis(4);
		for(String s:list){
			System.out.println(s);
		}
	}

}

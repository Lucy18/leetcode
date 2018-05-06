package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation_784 {

	public List<String> letterCasePermutation(String S) {
		char[] cs=S.toCharArray();
		char[] result=new char[cs.length];
		List<String> list=new ArrayList<String>();
		helper(cs, 0, result, list);
		return list;
	}
	
	public void helper(char[] cs,int index,char[] result,List<String> list){
		if(index==cs.length){
			list.add(String.valueOf(result));
			return;
		}
		if(cs[index]>='0'&&cs[index]<='9'){
			result[index]=cs[index];
			helper(cs, index+1, result, list);
		}
		else if(cs[index]>='a'&&cs[index]<='z'){
			result[index]=cs[index];
			helper(cs, index+1, result, list);
			result[index]=(char) (cs[index]-'a'+'A');
			helper(cs, index+1, result, list);
		}
		else if(cs[index]>='A'&&cs[index]<='Z'){
			result[index]=cs[index];
			helper(cs, index+1, result, list);
			result[index]=(char) (cs[index]-'A'+'a');
			helper(cs, index+1, result, list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letter_Case_Permutation_784 l=new Letter_Case_Permutation_784();
		List<String> list=l.letterCasePermutation("a1b2");
		for(String s:list){
			System.out.println(s);
		}
	}

}

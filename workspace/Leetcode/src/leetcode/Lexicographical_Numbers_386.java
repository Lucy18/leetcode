package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers_386 {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=9;i++){
			helper(i, n, list);
		}		
		return list;
	}
	
	public void helper(int number,int n,List<Integer> list){
		if(number>n){
			return;
		}
		else{
			list.add(number);
			for(int i=0;i<=9;i++){
				helper(10*number+i, n, list);
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lexicographical_Numbers_386 l=new Lexicographical_Numbers_386();
		List<Integer> list=l.lexicalOrder(34);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}

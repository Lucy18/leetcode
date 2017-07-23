package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Different_Ways_to_Add_Parentheses_241 {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result=new ArrayList<Integer>();
		char[] cs=input.toCharArray();
		boolean haveOperator=false;
		for(int i=0;i<cs.length;i++){
			if(cs[i]=='+'||cs[i]=='-'||cs[i]=='*'){
				haveOperator=true;
				String sub1=input.substring(0,i);
				String sub2=input.substring(i+1);
				List<Integer> list1=diffWaysToCompute(sub1);
				List<Integer> list2=diffWaysToCompute(sub2);
				for(Integer num1:list1){
					for(Integer num2:list2){
						int m=0;
						switch (cs[i]) {
						case '+':
							m=num1+num2;
							break;
						case '-':
							m=num1-num2;
							break;
						case '*':
							m=num1*num2;
							break;						
						}
						result.add(m);
					}
				}
			}
		}
		if(haveOperator==false){ //input是一个单独的数，没有符号
			int num=Integer.parseInt(input);
			result.add(num);
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Different_Ways_to_Add_Parentheses_241 d=new Different_Ways_to_Add_Parentheses_241();
		List<Integer> result=d.diffWaysToCompute("2*3-4*5");
		for(Integer i:result){
			System.out.print(i+" ");
		}
	}

}
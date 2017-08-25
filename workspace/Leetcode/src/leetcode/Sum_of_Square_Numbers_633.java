package leetcode;

import java.util.HashSet;

public class Sum_of_Square_Numbers_633 {

	public boolean judgeSquareSum(int c) {
		HashSet<Integer> set=new HashSet<Integer>();
		int currentNum=0;
		while(currentNum*currentNum>=0&&currentNum*currentNum<=c){
			if(currentNum*currentNum*2==c){
				return true;
			}
			if(set.contains(c-currentNum*currentNum)){
				return true;
			}
			set.add(currentNum*currentNum);	
			currentNum++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum_of_Square_Numbers_633 s=new Sum_of_Square_Numbers_633();
		System.out.println(s.judgeSquareSum(2147482647));
	}

}

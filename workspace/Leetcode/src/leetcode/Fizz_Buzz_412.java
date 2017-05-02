package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_412 {

	public List<String> fizzBuzz(int n) {
		List<String> result=new ArrayList<String>();
		for(int i=1;i<=n;i++){
			if(i%15==0){
				result.add("FizzBuzz");
			}
			else if(i%3==0){
				result.add("Fizz");
			}
			else if(i%5==0){
				result.add("Buzz");
			}
			else{
				result.add(String.valueOf(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fizz_Buzz_412 f=new Fizz_Buzz_412();
		List<String> list=f.fizzBuzz(15);
		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i));
		};

	}

}

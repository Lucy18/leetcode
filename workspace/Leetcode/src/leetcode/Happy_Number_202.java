package leetcode;

import java.util.HashSet;

public class Happy_Number_202 {

	public boolean isHappy(int n) {
		HashSet<Integer> set=new HashSet<Integer>();
		while(n!=1&&!set.contains(n)){
			set.add(n);
			int sum=0;
			while(n>0){
				int yu=n%10;
				n=n/10;
				sum+=yu*yu;
			}
			n=sum;
		}
		if(n==1){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Happy_Number_202 h=new Happy_Number_202();
		System.out.println(h.isHappy(12));
	}

}

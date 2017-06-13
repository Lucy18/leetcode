package leetcode;

import java.util.Arrays;

public class Node51_4_Canoe__Tester {
	public static void main(String[] args) {
		Node51_4_Canoe c=new Node51_4_Canoe();
		int n=(int)Math.ceil(Math.random()*10);
		long m=(int)Math.ceil(Math.random()*20);
		long[] peoples=new long[n];
		for(int i=0;i<n;i++){
			peoples[i]=(int)Math.ceil(Math.random()*m);
		}
		System.out.println(n);
		System.out.println(m);
		System.out.println(Arrays.toString(peoples));
		System.out.println(c.solve(n, m, peoples));
	}
}

package leetcode;

import java.util.Arrays;

public class Node51_3_ThrowPlate_tester {
	
	public static void main(String[] args) {
		Node51_3_ThrowPlate a=new Node51_3_ThrowPlate();
		Node51_3_ThrowPlate_faster b=new Node51_3_ThrowPlate_faster();
		for (int count = 0; count < 10; count++) {
			int n = (int) Math.ceil(Math.random() * 50000);
			int m = (int) Math.ceil(Math.random() * 50000);
			long[] W = new long[n];
			long[] D = new long[m];
			for (int i = 0; i < n; i++) {
				W[i] = (int) Math.ceil(Math.random() * 1000000000);
			}
			for (int i = 0; i < m; i++) {
				D[i] = (int) Math.ceil(Math.random() * 1000000000);
			}
				long time1=System.currentTimeMillis();             
			int r1=(int)a.solve(n, m, W, D);
				long time2=System.currentTimeMillis();  
			int r2=(int)b.solve(n, m, W, D);
				long time3=System.currentTimeMillis();  
				float excTime1=(float)(time2-time1);  
				float excTime2=(float)(time3-time2);  
				System.out.println("执行时间1："+excTime1+"ms");
				System.out.println("执行时间2："+excTime2+"ms");
			if (r1 != r2) {				
				System.out.println(n);
				System.out.println(m);
				System.out.println(Arrays.toString(W));
				System.out.println(Arrays.toString(D));
				b.solve(n, m, W, D);
				break;
			}
		}
	}

}

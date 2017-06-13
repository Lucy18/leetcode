package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_3_ThrowPlate_faster {
	
	public long solve(int n,int m,long[] W,long[] D){
		int WPointer=n-1;//井
		int DPointer=0;//盘子
		while (WPointer >=0 && DPointer < m) {
			while (WPointer >=0&&W[WPointer] < D[DPointer]) {
				WPointer--;
			}
			if(WPointer>=0){
				WPointer--;
				DPointer++;	
			}			
		}
		return DPointer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();//井的深度
		int m = in.nextInt();//盘子的数量
		long[] W=new long[n];//井
		W[0]=in.nextLong();;
		for(int i=1;i<n;i++){
			W[i]=in.nextLong();
			W[i]=Math.min(W[i], W[i-1]);
		}
		long[] D=new long[m];//盘子
		for(int i=0;i<m;i++){
			D[i]=in.nextLong();
		}
		in.close();//4 1 7 9 3 9 9
		Node51_3_ThrowPlate_faster node = new Node51_3_ThrowPlate_faster();
		long b = node.solve(n,m,W,D);

		out.println(b);
		out.flush();
		
	}

}

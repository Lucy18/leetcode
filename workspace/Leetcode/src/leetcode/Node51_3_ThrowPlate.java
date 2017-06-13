package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_3_ThrowPlate {
	
	public long solve(int n,int m,long[] W,long[] D){
		int WPointer=0;//井
		int WEnd=n;//最靠近井口的被盘子挡住的井深度,最下面的话是被地面挡住
		int DPointer=0;//盘子
		while (WPointer < WEnd && DPointer < m) {
			while (WPointer < WEnd && W[WPointer] >= D[DPointer]) {
				WPointer++;
			}
			if(WPointer==0){
				return DPointer;
			}
			else{
				WPointer--;
				WEnd = WPointer;
				DPointer++;
				WPointer = 0;
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
		for(int i=0;i<n;i++){
			W[i]=in.nextLong();
		}
		long[] D=new long[m];//盘子
		for(int i=0;i<m;i++){
			D[i]=in.nextLong();
		}
		in.close();//8 3 7 8 8 9 10 2 4 5 8 8 2
		Node51_3_ThrowPlate node = new Node51_3_ThrowPlate();
		long b = node.solve(n,m,W,D);

		out.println(b);
		out.flush();
	}

}

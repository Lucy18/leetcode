package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_8_Cannon{
	
	public int[] solve(int m,int n,int[] A,int[] B){
		int groundPointer=0;
		for(int cannonballPointer=0;cannonballPointer<n;cannonballPointer++){
			for(groundPointer=0;groundPointer<m;groundPointer++){
				if(A[groundPointer]>=B[cannonballPointer]){
					break;
				}
			}
			if(groundPointer==0||groundPointer==m){
				continue;
			}
			else{
				A[groundPointer-1]++;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int m = in.nextInt();//地形个数
		int n = in.nextInt();//炮弹个数
		int[] A=new int[m];//从左到右的地形高度
		int[] B=new int[n];//炮弹高度
		for(int i=0;i<m;i++){
			A[i]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			B[i]=in.nextInt();

		}
		in.close();
		Node51_8_Cannon node = new Node51_8_Cannon();
		int[] result = node.solve(m, n, A,B);
		for(int i=0;i<m;i++){
			out.println(result[i]);
		}	
		out.flush();
	}

}

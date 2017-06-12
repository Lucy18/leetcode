package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_2_WalkOfGrid {
	
	public long solve(int n,int[] grids){
		long result=0;
		long sum=0;		
		for(int i=0;i<n;i++){
			sum+=grids[i];
			if(sum<0){
				result+=(-sum);
				sum=0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int a = in.nextInt();
		int[] grids=new int[a];
		for(int i=0;i<a;i++){
			grids[i]=in.nextInt();
		}
		in.close();
		Node51_2_WalkOfGrid n = new Node51_2_WalkOfGrid();
		long b = n.solve(a,grids);

		out.println(b);
		out.flush();
	}

}

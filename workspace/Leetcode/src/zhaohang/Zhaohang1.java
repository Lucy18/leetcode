package zhaohang;

import java.util.Scanner;

public class Zhaohang1 {

	public int getResult(int[] a,int n){
		int xor=0;
		for(int i=1;i<=n;i++){
			xor=xor^i;
		}
		for(int i=0;i<a.length;i++){
			xor=xor^a[i];
		}
		return xor;
	}
	
	
	public static void main(String[] args) {
		Zhaohang1 h=new Zhaohang1();
		Scanner in = new Scanner(System.in);		
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		System.out.println(h.getResult(a,n));
		in.close();
	}

}

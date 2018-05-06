package wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WangYi3 {

	public void getCount(int n,int m,ArrayList<Work> work,int[] p){
		Collections.sort(work, new Comparator<Work>() {

			@Override
			public int compare(Work o1, Work o2) {
				if(o1.d<o2.d){
					return -1;
				}
				else if(o1.d>o2.d){
					return 1;
				}
				else{
					return o2.p-o1.p;
				}
			}		
		});
		for(int i=0;i<p.length;i++){
			int j=0;
			for(j=0;j<work.size();j++){
				if(work.get(j).d>p[i]){
					break;
				}				
			}
			j--;
			System.out.println(work.get(j).p);
		}
		
	}
	
	public static void main(String[] args) {
		WangYi3 t = new WangYi3();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Work> work=new ArrayList<Work>();
		int[] p=new int[m];
		for(int i=0;i<n;i++){
			int d=in.nextInt();
			int pp=in.nextInt();
			work.add(new Work(d, pp));
		}
		for(int i=0;i<m;i++){
			p[i]=in.nextInt();
		}
		
		t.getCount(n, m,work,p);
		in.close();
	}
	
	static class Work{
		int d;
		int p;
		public Work(int a,int b){
			d=a;
			p=b;
		}
	}
	

}

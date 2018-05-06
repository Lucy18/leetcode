package wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WangYi {
	
	public int getCount(ArrayList<Tri> list){
		Collections.sort(list, new Comparator<Tri>() {
			@Override
			public int compare(Tri o1, Tri o2) {
				if(o1.leftDownX<o2.leftDownX){
					return -1;
				}
				else if(o1.leftDownX>o2.leftDownX){
					return 1;
				}
				else{
					if(o1.leftDownY<o2.leftDownY){
						return -1;
					}
					else if(o1.leftDownY>o2.leftDownY){
						return 1;
					}
					else{
						return 0;
					}
				}
			}
		});
		int max=1;
		for(int i=0;i<list.size()-1;i++){
			int count=1;
			for(int j=i;j<list.size();j++){
				if(isOccupy(list.get(i), list.get(j))){
					count++;
				}
			}
			max=Math.max(count, max);
		}
		return max;
	}
	
	public boolean isOccupy(Tri t1,Tri t2){
		if(t1.rightUpX>=t2.leftDownX&&t1.rightUpY>=t2.leftDownY){
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		WangYi t=new WangYi();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] zuoxia=new int[n][2];
		int[][] youshang=new int[n][2];
		for(int i=0;i<n;i++){
			zuoxia[i][0]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			zuoxia[i][1]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			youshang[i][0]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			youshang[i][0]=in.nextInt();
		}
		ArrayList<Tri> list=new ArrayList<Tri>();
		for(int i=0;i<n;i++){
			list.add(new Tri(zuoxia[i][0], zuoxia[i][1], youshang[i][0], youshang[i][1]));
		}		
		System.out.println(t.getCount(list));
		in.close();
	}
	
	static class Tri{
		int leftDownX;
		int leftDownY;
		int rightUpX;
		int rightUpY;
		public Tri(int a,int b,int c,int d){
			leftDownX=a;
			leftDownY=b;
			rightUpX=c;
			rightUpY=d;
		}
	}

}

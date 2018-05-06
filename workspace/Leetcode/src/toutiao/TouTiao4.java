package toutiao;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TouTiao4 {

	public int maxOperation(LinkedList<Integer> a,LinkedList<Integer> b,int n,int m){
		double avg1=0;
		double avg2=0;
		avg1=calAvg(a);
		avg2=calAvg(b);
		LinkedList<Integer> bigg;
		LinkedList<Integer> small;
		double avgBig;double avgSmall;
		if(avg1>avg2){
			bigg=a;small=b;
			avgBig=avg1;avgSmall=avg2;
		}
		else{
			bigg=b;small=a;
			avgBig=avg2;avgSmall=avg1;
		}
		int count=0;
		int pos=findMinBigger(avgSmall, bigg,avgBig);
		while(pos!=-1){
			count++;
			int number=bigg.get(pos);
			bigg.remove(pos);
			small.add(number);
			avgSmall=calAvg(small);
			avgBig=calAvg(bigg);
			if(avgSmall>avgBig){
				Collections.sort(small);
				Collections.sort(bigg);
				LinkedList<Integer> tmp=small;
				small=bigg;
				bigg=tmp;
				double tmmp=avgSmall;
				avgSmall=avgBig;
				avgBig=tmmp;
			}
			pos=findMinBigger(avgSmall, bigg,avgBig);
		}
		return count;
	}
	
	public double calAvg(LinkedList<Integer> a){
		int n=a.size();
		int sum=0;
		for(Iterator<Integer> iter = a.iterator(); iter.hasNext();)  {
			sum+=iter.next();  
		}	
		return (double)sum/n;
	}
	
	public int findMinBigger(double avg,LinkedList<Integer> a,double avg2){
		int pos=0;
		for(Iterator<Integer> iter = a.iterator(); iter.hasNext();)  {
			int the=iter.next();  
			if(the>avg&&the<avg2){
				return pos;
			}
			pos++;
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		TouTiao4 t=new TouTiao4();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		LinkedList<Integer> a=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			a.add(in.nextInt());
		}
		LinkedList<Integer> b=new LinkedList<Integer>();
		for(int i=0;i<m;i++){
			b.add(in.nextInt());
		}
		Collections.sort(a);
		Collections.sort(b);
		System.out.println(t.maxOperation(a,b,n,m));
		in.close();
	}
	/**
	 * 3 5
       1 2 5
       2 3 4 5 6
	 */
}

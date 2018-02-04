package suan_fa_ke;

import java.util.Arrays;

public class ClosestPair {

	double distance(Point a,Point b){
	    return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}

	double closest(Point s[],int low,int high){
	    double d1,d2,d3,d;
	    Point[] p=new Point[high-low+1];
	    if(high-low == 1)
	        return distance(s[low],s[high]);
	    if(high-low == 2){
	        d1 = distance(s[low],s[low+1]);
	        d2 = distance(s[low+1],s[high]);
	        d3 = distance(s[low],s[high]);
	        if(d1<d2 && d1<d3){
	            return d1;
	        }
	        else{
	        	return Math.min(d2, d3);	           
	        }
	    }
	    else{
	        int mid = (low+high)/2;
	        d1 = closest(s,low,mid);
	        d2 = closest(s,mid+1,high);
	        d=Math.min(d1, d2);
	        int index = 0;
	        for(int i=mid;i>=low && s[i].x-s[mid].x<d;i--)
	            p[index++] = s[i];
	        for(int j=mid+1;j<=high && s[j].x-s[mid].x<d;j++)
	            p[index++] = s[j];
	        Arrays.sort(p, 0, index, (a,b) -> a.y-b.y==0?0:(a.y-b.y<0?-1:1));
	        for(int i=0;i<index-1;i++){
	            for(int j=i+1;j<index;j++){
	                d3 = distance(p[i],p[j]);
	                d=Math.min(d, d3);
	            }
	        }
	    }
	    return d;
	}
	
	double closestPair(Point s[]){
		 Arrays.sort(s,(a,b) -> a.x-b.x==0?0:(a.x-b.x<0?-1:1));
		 return closest(s, 0, s.length-1);
	}	
	
	static class Point{
		double x;
		double y;
	}
	
	public static void main(String[] args) {
		ClosestPair closestPair=new ClosestPair();
		Point a=new Point();
		a.x=0;
		a.y=0;
		Point b=new Point();
		b.x=1;
		b.y=2;
		Point c=new Point();
		c.x=0;
		c.y=1;
		Point d=new Point();
		d.x=1;
		d.y=0;
		Point e=new Point();
		e.x=1;
		e.y=2.5;
		Point f=new Point();
		f.x=2;
		f.y=2;
		Point g=new Point();
		g.x=2;
		g.y=3;
		Point h=new Point();
		h.x=4;
		h.y=3;
		Point i=new Point();
		i.x=4;
		i.y=2.75;
		
		Point[] points=new Point[]{a,b,c,d,e,f,g,h,i};
		System.out.println(closestPair.closestPair(points));
	}
}

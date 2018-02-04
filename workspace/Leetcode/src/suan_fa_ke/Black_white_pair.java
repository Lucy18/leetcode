package suan_fa_ke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定平面上有n个白点和n个黑点,任意三点不共线,试实施一个分治算法将每个白点与一个黑点相连,使所有连线互不相交。
 * Divide：按照横坐标，将所有点分为等量的左右两部分。
   Conquer：递归的将左右两部分进行黑白点对的匹配。
            当某部分中只有一个点或两个同色的点时，直接返回；
            有两个不同色的点时，将他们匹配。
   Merge：左右两部分中若黑白点完全匹配了，直接合并，返回；
          左右两部分没有匹配的点都是相同颜色，直接合并，返回；
          将左右两部分没有匹配的异色的点，依次匹配，若存在交叉，则可以通过与交叉线段有限次交换使其互不相交，
          当所有某侧单独的点都完成匹配，返回。

 */
public class Black_white_pair {
	
	List<Point[]> pairList=new ArrayList<Point[]>();
	
	double outer_product(Point a,Point b,Point c){
		return (b.x-a.x)*(c.y-a.y)-(c.x-a.x)*(b.y-a.y);
	}

	boolean across(Point a,Point b,Point c,Point d){
		return outer_product(a,b,c)*outer_product(a,b,d)<0&&outer_product(c,d,a)*outer_product(c,d,b)<0;
	}

	
	public List<Point> pair(Point[] p,int low,int high){
		List<Point> restList=new ArrayList<Point>();
		if(low>high){
			return restList;
		}
		if(low==high){
			restList.add(p[low]);
			return restList;
		}
		if(high-low==1){
			if(p[low].color!=p[high].color){
				pairList.add(new Point[]{p[low],p[high]});
				return restList;
			}
			else{
				restList.add(p[low]);
				restList.add(p[high]);
				return restList;
			}
		}
		int mid = (low+high)/2;
		List<Point> leftRest=pair(p, low, mid);
		List<Point> rightRest=pair(p, mid+1, high);
		if(leftRest.size()==0){
			return rightRest;
		}
		if(rightRest.size()==0){
			return leftRest;
		}
		if(leftRest.get(0).color==rightRest.get(0).color){
			restList.addAll(leftRest);
			restList.addAll(rightRest);
			return restList;
		}
		while(leftRest.size()>0&&rightRest.size()>0){
				Point a=leftRest.get(0);
				Point b=rightRest.get(0);
				boolean isOK=true;
				List<Point> white=new ArrayList<Point>();
				List<Point> black=new ArrayList<Point>();
				for(int k=0;k<pairList.size();k++){
					Point[] points=pairList.get(k);
					if(across(a, b, points[0], points[1])){
						isOK=false;
						addToConflictList(points[0],white,black);
						addToConflictList(points[1],white,black);
						pairList.remove(k);
						k--;
					}
				}
				if(isOK==false){
					addToConflictList(a,white,black);
					addToConflictList(b,white,black);	
					shuffle(black,white);
				}
				else{
					pairList.add(new Point[]{a,b});
				}
				leftRest.remove(0);
				rightRest.remove(0);
		}	
		if(leftRest.size()==0){
			return rightRest;
		}else{
			return leftRest;
		}
	}
	
	public void shuffle(List<Point> black,List<Point> white){
		int n=black.size();
		boolean isOK=false;
		while (!isOK){
			isOK=true;
			for (int i = 0; i < n; i++)		
				for (int j = 0; j < n; j++){		
					if (j!=i&&across(black.get(i),white.get(i),black.get(j),white.get(j))){
						isOK=false;
						Point tmp=white.get(i);
						white.set(i, white.get(j));
						white.set(j, tmp);
					}						
				}
		}
		for(int i=0;i<n;i++){
			pairList.add(new Point[]{black.get(i),white.get(i)});
		}
	}
	
	public void addToConflictList(Point p,List<Point> white,List<Point> black){
		if(p.color=='B'){
			black.add(p);
		}
		else{
			white.add(p);
		}
	}
	
	public List<Point[]> pair(Point[] p){
		Arrays.sort(p,(a,b) -> a.x-b.x==0?0:(a.x-b.x<0?-1:1));
		pair(p,0,p.length-1);
		return pairList;
	}
		
	
	static class Point{
		double x;
		double y;
		char color;//B代表黑点，W代表白点
	}
	
	public static void main(String[] args) {
		Black_white_pair bwp=new Black_white_pair();
		Point a=new Point();
		a.x=0;
		a.y=1;
		a.color='W';
		Point b=new Point();
		b.x=1;
		b.y=0;
		b.color='W';
		Point c=new Point();
		c.x=0;
		c.y=-1;
		c.color='B';
		Point d=new Point();
		d.x=-1;
		d.y=0;	
		d.color='B';
		Point[] p=new Point[]{a,b,c,d};
		List<Point[]> pairList=bwp.pair(p);
		for(Point[] pp:pairList){
			System.out.println("("+pp[0].x+","+pp[0].y+") "+"("+pp[1].x+","+pp[1].y+")");
		}
	}

}

package suan_fa_ke;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 设计一个算法用于找到经过给定的平面坐标中n(n≥5)个点的所有圆周,使得需要的圆周个数最少。 
 * keyboard 500 
 * Maximun_length 646
 * 
 * @author huanghanqian
 *
 */
public class Min_Circle_Num {

	double get_distance(Point a, Point b) {// 两点之间的距离
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	Point get_circle_center(Point a, Point b, Point c) {// 得到三角形外接圆的圆心
		Point center = new Point();
		double a1 = b.x - a.x;
		double b1 = b.y - a.y;
		double c1 = (a1 * a1 + b1 * b1) / 2.0;
		double a2 = c.x - a.x;
		double b2 = c.y - a.y;
		double c2 = (a2 * a2 + b2 * b2) / 2.0;
		double d = a1 * b2 - a2 * b1;
		center.x = a.x + (c1 * b2 - c2 * b1) / d;
		center.y = a.y + (a1 * c2 - a2 * c1) / d;
		return center;
	}

	// 判断三点是否共线
	public boolean inALine(Point x, Point y, Point z) {
		double x1 = x.x;
		double x2 = y.x;
		double x3 = z.x;
		double y1 = x.y;
		double y2 = y.y;
		double y3 = z.y;
		double a = x1 - x2;
		double b = y1 - y2;
		double c = x1 - x3;
		double d = y1 - y3;
		double det = b * c - a * d;
		if (Math.abs(det) < 1e-5) {			
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean inCircles(Point a,List<Circle> circles){
		for(Circle circle:circles){
			double distance=get_distance(a, new Point(circle.center_x,circle.center_y));
			if(Math.abs(distance-circle.radius)<1e-5){
				return true;
			}
		}
		return false;
	}

	public int getMinCircleNum(Point[] points) {
		int n = points.length;
		if (n <= 3) {
			return 1;
		}
		List<List<Integer>> combines = combine(n);
		Set<Integer> noCirclePointsIndexes=new HashSet<Integer>();
		List<Circle> circles=new ArrayList<Circle>();
		for (List<Integer> threePointsIndexes : combines) {
			Point a=points[threePointsIndexes.get(0)];
			Point b=points[threePointsIndexes.get(1)];
			Point c=points[threePointsIndexes.get(2)];
			if(inALine(a, b, c)){
				noCirclePointsIndexes.add(threePointsIndexes.get(0));
				noCirclePointsIndexes.add(threePointsIndexes.get(1));
				noCirclePointsIndexes.add(threePointsIndexes.get(2));
			}
			else{
				if(noCirclePointsIndexes.contains(threePointsIndexes.get(0))){
					noCirclePointsIndexes.remove(threePointsIndexes.get(0));
				}
				if(noCirclePointsIndexes.contains(threePointsIndexes.get(1))){
					noCirclePointsIndexes.remove(threePointsIndexes.get(1));
				}
				if(noCirclePointsIndexes.contains(threePointsIndexes.get(2))){
					noCirclePointsIndexes.remove(threePointsIndexes.get(2));
				}
				Point center=get_circle_center(a, b, c);
				double radius=get_distance(a, center);
				circles.add(new Circle(center.x,center.y,radius));
			}
		}
		for(int i=0;i<circles.size();i++){
			for(int j=i+1;j<circles.size();j++){
				double x1=circles.get(i).center_x;
				double x2=circles.get(j).center_x;
				double y1=circles.get(i).center_y;
				double y2=circles.get(j).center_y;
				double r1=circles.get(i).radius;
				double r2=circles.get(j).radius;
				if(Math.abs(x1-x2)<1e-5&&Math.abs(y1-y2)<1e-5&&Math.abs(r1-r2)<1e-5){
					circles.remove(j);
					j--;
				}
			}
		}
		Iterator<Integer> iterator=noCirclePointsIndexes.iterator();
		while(iterator.hasNext()){
			Integer integer=iterator.next();
			if(inCircles(points[integer], circles)){
				iterator.remove();
			}
		}
		int count=circles.size();
		if(noCirclePointsIndexes.size()!=0){
			if(noCirclePointsIndexes.size()%2==1){
				count++;
			}
			count+=noCirclePointsIndexes.size()/2;
		}
		return count;
	}

	public List<List<Integer>> combine(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(res, list, 0, n-1);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> list, int beginNum, int n) {
		if (list.size() == 3) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if (beginNum > n) {
			return;
		}
		for (int i = beginNum; i <= n; i++) {
			list.add(i);
			helper(res, list, i + 1, n);
			list.remove(list.size() - 1);
		}
	}

	static class Point {
		double x;
		double y;
		Point(){			
		}
		Point(double x,double y){
			this.x=x;
			this.y=y;
		}
	}
	
	class Circle{
		double center_x;
		double center_y;
		double radius;
		public Circle(double center_x,double center_y,double radius){
			this.center_x=center_x;
			this.center_y=center_y;
			this.radius=radius;
		}
	}
	
	public static void main(String[] args) {
		Min_Circle_Num m=new Min_Circle_Num();
		Point[] points=new Point[]{
				new Point(0, 2),
				new Point(2, 0),
				new Point(Math.sqrt(2), Math.sqrt(2)),
				new Point(1, 3)
		};
		System.out.println(m.getMinCircleNum(points));		
	}
}

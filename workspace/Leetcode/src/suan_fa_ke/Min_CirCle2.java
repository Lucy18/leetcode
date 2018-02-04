package suan_fa_ke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Min_CirCle2 {

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
		if (Math.abs(det) < 1e-6) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getMinCircleNum(List<Point> points) {
		int n = points.size();
		if (n==0) return 0;
		if (n <=2) {
			return 1;
		}
		if (n==3){
			if(inALine(points.get(0), points.get(1), points.get(2))){
				return 2;
			}
			else{
				return 1;
			}
		}
		List<Circle> circles=new ArrayList<Circle>();
		List<List<Point>> combines = combine(points);
		for (List<Point> threePoints : combines) {
			Point a = threePoints.get(0);
			Point b = threePoints.get(1);
			Point c = threePoints.get(2);
			if(!inALine(a, b, c)){
				Point center = get_circle_center(a, b, c);
				double radius = get_distance(a, center);
				boolean isIn=false;
				for (int i = 0; i < circles.size(); i++) {
					double x = circles.get(i).center_x;
					double y = circles.get(i).center_y;
					double r = circles.get(i).radius;
					if (Math.abs(x - center.x) < 1e-6 && Math.abs(y - center.y) < 1e-6
							&& Math.abs(r - radius) < 1e-6) {
						circles.get(i).weight++;
						isIn=true;
						break;
					}
				}
				if(isIn==false){
					circles.add(new Circle(center.x, center.y, radius));
				}				
			}
		}
		Collections.sort(circles,(a,b) -> b.weight-a.weight);
//		int max=circles.get(0).weight;
		int min=circles.size();
		for(int i=0;i<circles.size()&&circles.get(i).weight>1;i++){
			List<Point> removePoints=new ArrayList<Point>();
			Circle circle=circles.get(i);
			Iterator<Point> iterator = points.iterator();
			while (iterator.hasNext()) {
				Point pp = iterator.next();
				double distance = get_distance(pp, new Point(circle.center_x, circle.center_y));
				if (Math.abs(distance - circle.radius) < 1e-6) {
					removePoints.add(pp);
					iterator.remove();
				}
			}
			min=Math.min(min, 1+getMinCircleNum(points));
			for(Point pp:removePoints){
				points.add(pp);
			}			
		}	
		return min;
	}
	
	public List<List<Point>> combine(List<Point> points) {
		List<List<Point>> res = new ArrayList<List<Point>>();
		List<Point> list = new ArrayList<Point>();
		int n = points.size() - 1;
		helper(points, res, list, 0, n);
		return res;
	}

	public void helper(List<Point> points, List<List<Point>> res, List<Point> list, int beginNum, int n) {
		if (list.size() == 3) {
			res.add(new ArrayList<Point>(list));
			return;
		}
		if (beginNum > n) {
			return;
		}
		for (int i = beginNum; i <= n; i++) {
			list.add(points.get(i));
			helper(points, res, list, i + 1, n);
			list.remove(list.size() - 1);
		}
	}

	static class Point {
		double x;
		double y;

		Point() {
		}

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Circle {
		double center_x;
		double center_y;
		double radius;
		int weight;

		public Circle(double center_x, double center_y, double radius) {
			this.center_x = center_x;
			this.center_y = center_y;
			this.radius = radius;
			weight=1;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Min_CirCle2 m = new Min_CirCle2();
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(0, 2));
		points.add(new Point(2, 0));
		points.add(new Point(Math.sqrt(2), Math.sqrt(2)));
		points.add(new Point(1, 0));
		points.add(new Point(0, 1));
		points.add(new Point(-1, 0));
		points.add(new Point(0, -1));
		System.out.println(m.getMinCircleNum(points));
	}

}

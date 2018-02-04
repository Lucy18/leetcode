package suan_fa_ke;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class New_Min_CirCle {

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

	// 点a是否在这些圆圈上
	public boolean inCircles(Point a, List<Circle> circles) {
		for (Circle circle : circles) {
			double distance = get_distance(a, new Point(circle.center_x, circle.center_y));
			if (Math.abs(distance - circle.radius) < 1e-6) {
				return true;
			}
		}
		return false;
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

	public int getMinCircleNum(List<Point> points, List<Circle> circles) {
		int n = points.size();
		if (n==0) return 0;
		if (n <= 3) {
			return 1;
		}
		List<List<Point>> combines = combine(points);
		int min = n;
		for (List<Point> threePoints : combines) {
			int count;
			Point a = threePoints.get(0);
			Point b = threePoints.get(1);
			Point c = threePoints.get(2);
			Iterator<Point> iterator = points.iterator();
			while (iterator.hasNext()) {
				Point pp = iterator.next();
				if (pp == a || pp == b || pp == c) {
					iterator.remove();
				}
			}
			boolean aIn = false;
			boolean bIn = false;
			boolean cIn = false;
			if (inCircles(a, circles)) {
				aIn = true;
			}
			if (inCircles(b, circles)) {
				bIn = true;
			}
			if (inCircles(c, circles)) {
				cIn = true;
			}
			if (aIn && bIn && cIn) {
				count = getMinCircleNum(points, circles);
			} else if ((!aIn) && (!bIn) && (!cIn)) {
				if (inALine(a, b, c)) {
					count = 2;
				} else {
					count = 1;
					Point center = get_circle_center(a, b, c);
					double radius = get_distance(a, center);
					for (int i = 0; i < circles.size(); i++) {
						double x = circles.get(i).center_x;
						double y = circles.get(i).center_y;
						double r = circles.get(i).radius;
						if (Math.abs(x - center.x) < 1e-6 && Math.abs(y - center.y) < 1e-6
								&& Math.abs(r - radius) < 1e-6) {
							count--;
							break;
						}
					}
					if (count == 1) {
						circles.add(new Circle(center.x, center.y, radius));
					}
				}
				int next = getMinCircleNum(points, circles);
				if(count==1){
					circles.remove(circles.size() - 1);
				}			
				count += next;
			} else {
				if (!aIn) {
					points.add(a);
				}
				if (!bIn) {
					points.add(b);
				}
				if (!cIn) {
					points.add(c);
				}
				count = getMinCircleNum(points, circles);
			}
			if ((aIn && bIn && cIn)||((!aIn) && (!bIn) && (!cIn))){
				points.add(a);
				points.add(b);
				points.add(c);
			}
			else{
				if (aIn) {
					points.add(a);
				}
				if (bIn) {
					points.add(b);
				}
				if (cIn) {
					points.add(c);
				}
			}	
			min = Math.min(count, min);
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

		public Circle(double center_x, double center_y, double radius) {
			this.center_x = center_x;
			this.center_y = center_y;
			this.radius = radius;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		New_Min_CirCle n = new New_Min_CirCle();
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(0, 2));
		points.add(new Point(2, 0));
//		points.add(new Point(Math.sqrt(2), Math.sqrt(2)));
		points.add(new Point(1, 0));
		points.add(new Point(0, 1));
		points.add(new Point(-1, 0));
		points.add(new Point(0, -1));
		points.add(new Point(1, 1));
		points.add(new Point(3, 0));
		points.add(new Point(3, 1));
		points.add(new Point(2, 2));
		points.add(new Point(101, 102));
		List<Circle> circles = new ArrayList<Circle>();
//		circles.add(new Circle(1.5, 1.5, 1.58113883));
//		System.out.println(n.inCircles(new Point(0,1), circles));
//		System.out.println(n.inCircles(new Point(1,3), circles));
		System.out.println(n.getMinCircleNum(points, circles));
	}

}

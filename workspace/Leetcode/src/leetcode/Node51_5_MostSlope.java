package leetcode;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Node51_5_MostSlope {
	
	public ArrayList<int[]> solve(int n,long[][] zuobiaos){
		Coordinate[] cs=new Coordinate[n];
		for(int i=0;i<n;i++){
			cs[i]=new Coordinate(zuobiaos[i][0], zuobiaos[i][1], i+1);
		}
		quickSort(cs, 0, n-1);
		long maxSlope=Long.MIN_VALUE;
		ArrayList<int[]> maxSlopeCoordinates=new ArrayList<int[]>();
		for(int i=0;i<=n-2;i++){
			Coordinate firstNode=cs[i];
			Coordinate nextNode=cs[i+1];
			long thisSlope=(nextNode.y-firstNode.y)/(nextNode.x-firstNode.x);
			if(thisSlope>maxSlope){
				maxSlope=thisSlope;
				maxSlopeCoordinates.clear();
				int[] theResult=new int[]{firstNode.number,nextNode.number};
				maxSlopeCoordinates.add(theResult);
			}
			else if(thisSlope==maxSlope){
				int[] theResult=new int[]{firstNode.number,nextNode.number};
				maxSlopeCoordinates.add(theResult);
			}
		}
		return maxSlopeCoordinates;
	}
	
	//按照x坐标将这些点从小到大排序
	public void quickSort(Coordinate[] cs, int left, int right) {
		if (left < right) {
			int low = left;
			int high = right;
			Coordinate pivot = cs[low];
			while (low < high) {
				while (low < high && cs[high].x >= pivot.x) {
					high--;
				}
				if (low < high) {
					cs[low] = cs[high];
					low++;
				}
				while (low < high && cs[low].x <= pivot.x) {
					low++;
				}
				if (low < high) {
					cs[high] = cs[low];
					high--;
				}
			}
			cs[low] = pivot;
			quickSort(cs, left, low - 1);
			quickSort(cs, low + 1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();//点的数量
		long[][] zuobiaos=new long[n][2];
		for(int i=0;i<n;i++){
			long x=in.nextLong();
			long y=in.nextLong();
			long[] the=new long[]{x,y};
			zuobiaos[i]=the;
		}
		in.close();
		Node51_5_MostSlope node = new Node51_5_MostSlope();
		ArrayList<int[]> b = node.solve(n,zuobiaos);
		for(int i=0;i<b.size();i++){
			int[] ar=b.get(i);
			out.println(ar[0]+" "+ar[1]);
		}
		out.flush();
	}
	
	class Coordinate{
		long x;
		long y;
		int number;
		public Coordinate(long x,long y,int number){
			this.x=x;
			this.y=y;
			this.number=number;
		}
	}

}

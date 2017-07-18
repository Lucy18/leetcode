package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Number_of_Boomerangs_447 {

	public int numberOfBoomerangs(int[][] points) {
		int n=points.length;
		double[][] DP=new double[n][n];
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				double d2=Math.pow(points[i][0]-points[j][0],2)+Math.pow(points[i][1]-points[j][1],2);
				double distance=Math.sqrt(d2);
				DP[i][j]=distance;
				DP[j][i]=distance;
			}
		}
		int result=0;
		for(int firstPointIndex=0;firstPointIndex<n;firstPointIndex++){
			Map<Double,Integer> map=new HashMap<Double,Integer>();
			for(int i=0;i<n;i++){
				if(i==firstPointIndex){
					continue;
				}
				int count=map.getOrDefault(DP[firstPointIndex][i], 0);
				count++;
				map.put(DP[firstPointIndex][i], count);
			}
			Iterator iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				int val = (int)entry.getValue();
				if(val>=2){
					result+=(val*(val-1));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_of_Boomerangs_447 n=new Number_of_Boomerangs_447();
		int[][] points=new int[][]{
			{0,0},{1,0},{2,0}
		};
		System.out.println(n.numberOfBoomerangs(points));
	}

}

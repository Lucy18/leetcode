package leetcode;

import java.util.Arrays;

public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {

	public int findMinArrowShots(int[][] points) {
		if(points==null||points.length==0){
			return 0;
		}
		int arrows=0;
		Arrays.sort(points,(a,b) -> a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);
		int end=points[0][1];
		arrows+=1;
		for(int i=1;i<points.length;i++){
			if(points[i][0]>end){
				arrows+=1;
				end=points[i][1];
			}
			else{
				end=Math.min(end, points[i][1]);
			}
		}
		return arrows;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Number_of_Arrows_to_Burst_Balloons_452 m=new Minimum_Number_of_Arrows_to_Burst_Balloons_452();
		int[][] points=new int[][]{
			{10,16},{2,8},{1,6},{7,12}
		};
		System.out.println(m.findMinArrowShots(points));
	}

}

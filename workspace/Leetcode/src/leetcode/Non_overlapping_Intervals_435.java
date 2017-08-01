package leetcode;

import java.util.Arrays;

public class Non_overlapping_Intervals_435 {

	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length==0){
			return 0;
		}
		Arrays.sort(intervals,(a,b)->(a.end-b.end));
		int longest=1;
		int end=intervals[0].end;
		for(int i=1;i<intervals.length;i++){
			if(intervals[i].start>=end){
				longest++;
				end=intervals[i].end;
			}
		}
		return intervals.length-longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Non_overlapping_Intervals_435 n=new Non_overlapping_Intervals_435();
		Interval[] intervals=new Interval[1];
		intervals[0]=new Interval(1, 2);
		System.out.println(n.eraseOverlapIntervals(intervals));
	}

}

package leetcode;

import java.util.Arrays;

public class Find_Right_Interval_436 {

	public int[] findRightInterval(Interval[] intervals) {		
		int n=intervals.length;
		if(n==1){
			return new int[]{-1};
		}
		int[] result=new int[n];
		IntervalWithIndex[] intervalWithIndexs=new IntervalWithIndex[n];
		for(int i=0;i<n;i++){
			IntervalWithIndex in=new IntervalWithIndex(intervals[i], i);
			intervalWithIndexs[i]=in;
		}
		Arrays.sort(intervalWithIndexs, (a,b)->(a.interval.start-b.interval.start));
		for(int i=0;i<n;i++){
			int index=intervalWithIndexs[i].index;
			Interval interval=intervalWithIndexs[i].interval;
			boolean isFind=false;
			for(int j=i+1;j<n;j++){
				if(intervalWithIndexs[j].interval.start>=interval.end){
					isFind=true;
					result[index]=intervalWithIndexs[j].index;
					break;
				}
			}
			if(isFind==false){
				result[index]=-1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Right_Interval_436 f=new Find_Right_Interval_436();
		Interval[] intervals=new Interval[3];
		intervals[0]=new Interval(1, 4);
		intervals[1]=new Interval(2, 3);
		intervals[2]=new Interval(3, 4);
		System.out.println(Arrays.toString(f.findRightInterval(intervals)));
	}
	
	class IntervalWithIndex{
		Interval interval;
		int index;
		public IntervalWithIndex(Interval interval,int index) {
			this.interval=interval;
			this.index=index;
		}
	}

}

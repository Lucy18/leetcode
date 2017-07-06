package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Time_Difference_539 {

	public int findMinDifference(List<String> timePoints) {
		int[][] time=new int[24][60];
		int min=Integer.MAX_VALUE;
		for(String timeString:timePoints){
			String[] split=timeString.split(":");
			int hour=Integer.valueOf(split[0]);
			int minute=Integer.valueOf(split[1]);
			if(time[hour][minute]==1){
				return 0;
			}
			else{
				time[hour][minute]=1;
			}			
		}
		int i,j=0;
		int[] before=new int[2],current=new int[2];
		boolean isFindBefore=false;
		int[] linchenfirst=new int[2];//保留凌晨第一个时间，用来与前一天最后一个时间相减
		for(i=0;i<24;i++){
			for(j=0;j<60;j++){
				if(time[i][j]==1){
					if(isFindBefore==false){
						before[0]=i;
						before[1]=j;
						linchenfirst[0]=i;
						linchenfirst[1]=j;
						isFindBefore=true;
					}
					else{
						current[0]=i;
						current[1]=j;
						int difference=difference(before, current);
						min=min<=difference?min:difference;
						before[0]=i;
						before[1]=j;
					}
				}
			}
		}
		int difference=difference(current, linchenfirst);
		min=min<=difference?min:difference;
		return min;
	}
	
	public int difference(int[] before,int[] current){
		if(before[0]==current[0]){
			return Math.abs(current[1]-before[1]);
		}
		else if(before[0]<current[0]){
			int minute=(current[0]-before[0])*60;
			if(before[1]<current[1]){
				minute+=current[1]-before[1];
			}
			else{
				minute-=before[1]-current[1];
			}
			return minute;
		}
		else{//一般current都会比before大的，这种情况应该是过了凌晨了
			current[0]+=24;
			return difference(before, current);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Time_Difference_539 m=new Minimum_Time_Difference_539();
		List<String> list=new ArrayList<String>();
		list.add("00:00");
		list.add("23:59");
		list.add("00:00");
		System.out.println(m.findMinDifference(list));
	}

}

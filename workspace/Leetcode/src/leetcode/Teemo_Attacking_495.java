package leetcode;

public class Teemo_Attacking_495 {

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0) 
			return 0;
		int count=0;
		int length=timeSeries.length;
		for(int i=0;i<length;i++){
			if(i!=length-1){
				if(timeSeries[i]+duration>=timeSeries[i+1]){
					count+=(timeSeries[i+1]-timeSeries[i]);
				}
				else{
					count+=duration;
				}
			}
			else{
				count+=duration;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teemo_Attacking_495 t=new Teemo_Attacking_495();
		int[] timeSeries=new int[]{1,2};
		int duration=2;
		System.out.println(t.findPoisonedDuration(timeSeries, duration));
	}

}

package leetcode;

public class Poor_Pigs_458 {

	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if(buckets==1){
			return 0;
		}
		int length=minutesToTest/minutesToDie+1;
		int pigNum=1;
		int total=length;
		while(total<buckets){
			total=total*length;
			pigNum++;
		}
		return pigNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Poor_Pigs_458 p=new Poor_Pigs_458();
		System.out.println(p.poorPigs(1, 1, 1));
	}

}

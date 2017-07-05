package leetcode;

public class Count_Numbers_with_Unique_Digits_357 {

	public int countNumbersWithUniqueDigits(int n) {
		if(n==0){
			return 1;
		}
		int result=0;
		while(n>1){
			int product=9;//积
			int multiplier=9;//乘数
			for(int i=1;i<n;i++){
				product=product*multiplier;
				multiplier--;
			}
			result+=product;
			n--;
		}
		result+=10;//加上0~9
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count_Numbers_with_Unique_Digits_357 c=new Count_Numbers_with_Unique_Digits_357();
		System.out.println(c.countNumbersWithUniqueDigits(2));
	}

}

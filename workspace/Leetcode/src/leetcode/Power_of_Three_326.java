package leetcode;

public class Power_of_Three_326 {

	public boolean isPowerOfThree(int n) {
		if(n%10!=3 &&n%10!=9 &&n%10!=7 &&n%10!=1){
			return false;
		}
		while(n>1){
			if(n%3!=0){
				return false;
			}
			n=n/3;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Power_of_Three_326 p=new Power_of_Three_326();
		System.out.println(p.isPowerOfThree(1));
	}

}

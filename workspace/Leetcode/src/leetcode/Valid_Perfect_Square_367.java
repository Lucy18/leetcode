package leetcode;

public class Valid_Perfect_Square_367 {

	public boolean isPerfectSquare(int num) {
		//1*1末尾1，2*2末尾4，3*3末尾9，4*4末尾6，5*5末尾5，
		//6*6末尾6，7*7末尾9，8*8末尾4，9*9末尾1,10*10末尾0
		int mowei=num%10;
		if(mowei!=0&& mowei!=1 && mowei!=4 && mowei!=5 && mowei!=6 &&mowei!=9){
			return false;
		}
		int sqrt=1;
		while(sqrt*sqrt<=num){
			if(sqrt*sqrt==num){
				return true;
			}
			sqrt++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Perfect_Square_367 v=new Valid_Perfect_Square_367();
		System.out.println(v.isPerfectSquare(14));
	}

}

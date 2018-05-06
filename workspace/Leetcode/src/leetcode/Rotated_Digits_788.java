package leetcode;

public class Rotated_Digits_788 {

	//018
	//至少一个2569
	//不能有347
	public int rotatedDigits(int N) {
		int count=0;
		for(int i=1;i<=N;i++){
			if(isValid(i)){
				count++;
			}
		}
		return count;
	}
	
	public boolean isValid(int n){
		boolean find2569=false;
		while(n>0){
			int digit=n%10;
			if(digit==2||digit==5||digit==6||digit==9){
				find2569=true;
			}
			if(digit==3||digit==4||digit==7){
				return false;
			}
			n=n/10;
		}
		return find2569;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rotated_Digits_788 r=new Rotated_Digits_788();
		System.out.println(r.rotatedDigits(857));
	}

}

package leetcode;

public class Elimination_Game_390 {

	public int lastRemaining(int n) {
		return leftToRight(n);
	}
	
	public int leftToRight(int n){
		if(n==1){
			return 1;
		}
		else {
			return 2*rightToLeft(n/2);
		}
	}
	
	public int rightToLeft(int n){
		if(n==1){
			return 1;
		}
		else{
			if(n%2==0){
				return 2*leftToRight(n/2)-1;
			}
			else{
				return 2*leftToRight(n/2);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elimination_Game_390 e=new Elimination_Game_390();
		System.out.println(e.lastRemaining(24));
	}

}

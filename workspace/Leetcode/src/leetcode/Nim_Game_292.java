package leetcode;

public class Nim_Game_292 {
	
	public boolean canWinNim(int n) {		
		return n%4==0?false:true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nim_Game_292 n = new Nim_Game_292();
		System.out.println(n.canWinNim(4));
	}

}

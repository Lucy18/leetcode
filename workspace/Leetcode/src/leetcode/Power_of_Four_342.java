package leetcode;

public class Power_of_Four_342 {

	public boolean isPowerOfFour(int num) {
		return Integer.toString(num, 4).matches("10*");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power_of_Four_342 p=new Power_of_Four_342();
		System.out.println(p.isPowerOfFour(2));
	}

}

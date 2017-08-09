package leetcode;

public class Power_of_Two_231 {

	public boolean isPowerOfTwo(int n) {
		return n>0&&1073741824%n==0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power_of_Two_231 p=new Power_of_Two_231();
		System.out.println(p.isPowerOfTwo(12));
	}

}

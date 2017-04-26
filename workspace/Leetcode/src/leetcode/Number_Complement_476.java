package leetcode;

public class Number_Complement_476 {

	public int findComplement(int num) {
		int result=0;
		int pos=0;
		while(num>=1){
			int yu=num%2;
			int bit=(yu==1?0:1);
			result+=bit*Math.pow(2, pos);
			pos++;
			num=num/2;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_Complement_476 n = new Number_Complement_476();
		System.out.println(n.findComplement(5));
		System.out.println(n.findComplement(1));
	}

}

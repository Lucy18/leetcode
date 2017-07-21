package leetcode;

public class Integer_to_Roman_12 {

	public String intToRoman(int num) {
		String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    int qian=num/1000;//千位上的数
	    int bai=(num%1000)/100;//百位上的数
	    int shi=(num%100)/10;//十位上的数
	    int ge=num%10;//个位上的数
	    String result=M[qian]+C[bai]+X[shi]+I[ge];
		return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer_to_Roman_12 i=new Integer_to_Roman_12();
		System.out.println(i.intToRoman(3999));
	}
	
}

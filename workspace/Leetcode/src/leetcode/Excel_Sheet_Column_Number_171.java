package leetcode;

public class Excel_Sheet_Column_Number_171 {

	public int titleToNumber(String s) {
		int result=0;
		char[] chars=s.toCharArray();
		int power=0;
		for(int i=chars.length-1;i>=0;i--){
			int the=chars[i]-'A'+1;
			result=result + (int)Math.pow(26,power)*the;
			power++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel_Sheet_Column_Number_171 e=new Excel_Sheet_Column_Number_171();
		System.out.println(e.titleToNumber("AB"));
	}

}

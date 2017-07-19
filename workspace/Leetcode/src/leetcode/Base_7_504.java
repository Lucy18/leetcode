package leetcode;

public class Base_7_504 {

	public String convertToBase7(int num) {
		if(num==0){
			return "0";
		}
		String result="";
		int numPositive=Math.abs(num);
		while(numPositive>=1){
			int yu=numPositive%7;
			result=yu+result;
			numPositive=numPositive/7;
		}
		if(num<0){
			result="-"+result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base_7_504 b=new Base_7_504();
		System.out.println(b.convertToBase7(0));
	}

}

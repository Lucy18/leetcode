package leetcode;

public class Reverse_String_344 {

	public String reverseString(String s) {
		int length=s.length();
		if(length<=1){
			return s;
		}
		int halfLength=length/2;
		String left=s.substring(0,halfLength);
		String right=s.substring(halfLength,length);
		return reverseString(right)+reverseString(left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_String_344 r=new Reverse_String_344();
		System.out.println(r.reverseString("hello"));
	}

}

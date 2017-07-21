package leetcode;

public class Reverse_String_II_541 {

	public String reverseStr(String s, int k) {
		String result="";
		boolean isReverse=true;
		int pointer=0;
		char[] cs=s.toCharArray();
		while(pointer<cs.length){
			String theS="";
			for(int i=0;i<k&&pointer<cs.length;i++){
				theS+=cs[pointer];
				pointer++;
			}
			if(isReverse){
				result+=reverse(theS);
			}
			else{
				result+=theS;
			}
			isReverse=(isReverse==true?false:true);
		}
		return result;
	}
	
	public String reverse(String s){
		String result="";
		char[] cs=s.toCharArray();
		for(int i=cs.length-1;i>=0;i--){
			result+=cs[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_String_II_541 r=new Reverse_String_II_541();
		System.out.println(r.reverseStr("abcdefg",2));
	}

}

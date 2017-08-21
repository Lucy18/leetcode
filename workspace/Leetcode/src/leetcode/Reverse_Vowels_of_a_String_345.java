package leetcode;

public class Reverse_Vowels_of_a_String_345 {

	public String reverseVowels(String s) {
		StringBuilder sb=new StringBuilder(s);
		int frontPointer=0;
		int behindPointer=s.length()-1;
		while(frontPointer<behindPointer){
			while(frontPointer<s.length()&&!isVowels(sb.charAt(frontPointer))){
				frontPointer++;
			}
			while(behindPointer>=0&&!isVowels(sb.charAt(behindPointer))){
				behindPointer--;
			}
			if(frontPointer<behindPointer){
				char tmp=sb.charAt(frontPointer);
				sb.setCharAt(frontPointer, sb.charAt(behindPointer));
				sb.setCharAt(behindPointer, tmp);
				frontPointer++;
				behindPointer--;
			}
		}
		return sb.toString();
	}
	
	public boolean isVowels(char c){
		return c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'
	           ||c=='o'||c=='O'||c=='u'||c=='U';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_Vowels_of_a_String_345 r=new Reverse_Vowels_of_a_String_345();
		System.out.println(r.reverseVowels("leetcode"));
	}

}

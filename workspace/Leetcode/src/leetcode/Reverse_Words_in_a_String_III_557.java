package leetcode;

public class Reverse_Words_in_a_String_III_557 {
	
	public String reverseWord(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	public String reverseWords(String s) {
		String[] array = s.split(" ");
		String result="";
		result+=reverseWord(array[0]);
		for(int i=1;i<array.length;i++){
			result+=" "+reverseWord(array[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_Words_in_a_String_III_557 r = new Reverse_Words_in_a_String_III_557();
        System.out.println(r.reverseWords("Let's take LeetCode contest"));
	}

}

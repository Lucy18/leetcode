package leetcode;

public class Longest_Palindrome_409 {

	public int longestPalindrome(String s) {
		int result=0;		
		int[] chars=new int[128];
		char[] arr=s.toCharArray();
		for(int i=0;i<arr.length;i++){
			chars[arr[i]]++;
		}
		boolean hasOdd=false;
		for(int i=0;i<128;i++){
			if(chars[i]>0){
				if(chars[i]%2==0){
					result+=chars[i];
				}
				else{
					hasOdd=true;
					result+=(chars[i]/2)*2;//也可以写作chars[i] - 1;
				}
			}
		}
		if(hasOdd){
			result+=1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Palindrome_409 l=new Longest_Palindrome_409();
		System.out.println(l.longestPalindrome("aaabbccc"));
	}

}

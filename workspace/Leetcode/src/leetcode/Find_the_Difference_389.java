package leetcode;

public class Find_the_Difference_389 {

	public char findTheDifference(String s, String t) {
		int[] letters=new int[26];
		char[] s_array=s.toCharArray();
		char[] t_array=t.toCharArray();
		for(int i=0;i<t_array.length;i++){
			letters[t_array[i]-'a']++;
		}
		for(int i=0;i<s_array.length;i++){
			letters[s_array[i]-'a']--;
		}
		for(int i=0;i<26;i++){
			if(letters[i]==1){
				return (char)(i+'a');
			}
		}
		return ' ';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_the_Difference_389 f=new Find_the_Difference_389();
		System.out.println(f.findTheDifference("abcd", "abcde"));
	}

}

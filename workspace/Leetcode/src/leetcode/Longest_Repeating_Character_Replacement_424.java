package leetcode;

public class Longest_Repeating_Character_Replacement_424 {

	public int characterReplacement(String s, int k) {
		int[] letters=new int[26];
		int maxRepeatedLength=0;
		int maxCount=0;
		int start=0;
		for(int end=0;end<s.length();end++){
			char c=s.charAt(end);
			letters[c-'A']++;
			maxCount=Math.max(maxCount, letters[c-'A']);
			while( (end-start+1-maxCount) > k ){
				letters[s.charAt(start)-'A']--;
				start++;			
			}
			maxRepeatedLength=Math.max(maxRepeatedLength, end-start+1);
		}
		return maxRepeatedLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Repeating_Character_Replacement_424 l=new Longest_Repeating_Character_Replacement_424();
		System.out.println(l.characterReplacement("ABAA", 0));
	}

}

package leetcode;

public class Ransom_Note_383 {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] magazineChars=new int[26];
		char[] chars1=ransomNote.toCharArray();
		char[] chars2=magazine.toCharArray();
		for(int i=0;i<chars2.length;i++){
			int index=chars2[i]-'a';
			magazineChars[index]++;
		}
		for(int i=0;i<chars1.length;i++){
			int index=chars1[i]-'a';
			magazineChars[index]--;
			if(magazineChars[index]<0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ransom_Note_383 r=new Ransom_Note_383();
		System.out.println(r.canConstruct("aa", "aab"));
	}

}

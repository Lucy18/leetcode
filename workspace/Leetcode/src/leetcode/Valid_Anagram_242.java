package leetcode;

public class Valid_Anagram_242 {

	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;
		}
		int n=s.length();
		int[] chars1=new int[128];
		int[] chars2=new int[128];
		char[] ar1=s.toCharArray();
		for(int i=0;i<n;i++){
			chars1[ar1[i]]++;
		}
		char[] ar2=t.toCharArray();
		for(int i=0;i<n;i++){
			chars2[ar2[i]]++;
		}
		for(int i=0;i<128;i++){
			if(chars1[i]!=chars2[i]){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Anagram_242 v=new Valid_Anagram_242();
		System.out.println(v.isAnagram("anagram", "nagaram"));
	}

}

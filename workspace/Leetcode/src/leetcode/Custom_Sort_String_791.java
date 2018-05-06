package leetcode;

public class Custom_Sort_String_791 {

	public String customSortString(String S, String T) {
		char[] SC=S.toCharArray();
		char[] TC=T.toCharArray();
		int[] map=new int[26];
		for(int i=0;i<TC.length;i++){
			int index=TC[i]-'a';
			map[index]++;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<SC.length;i++){
			int index=SC[i]-'a';
			while(map[index]>0){
				sb.append(SC[i]);
				map[index]--;
			}
		}
		for(int i=0;i<26;i++){
			while(map[i]>0){
				sb.append((char)(i+'a'));
				map[i]--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Custom_Sort_String_791 c=new Custom_Sort_String_791();
		System.out.println(c.customSortString("cba", "abcd"));
	}

}

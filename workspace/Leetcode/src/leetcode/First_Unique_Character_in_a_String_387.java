package leetcode;

public class First_Unique_Character_in_a_String_387 {

	public int firstUniqChar(String s) {
		char[] chars=s.toCharArray();
		int[] ASCII=new int[128];
		for(int i=0;i<s.length();i++){
			ASCII[chars[i]]++;
		}
		for(int i=0;i<s.length();i++){
			if(ASCII[chars[i]]==1){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First_Unique_Character_in_a_String_387 f=new First_Unique_Character_in_a_String_387();
		System.out.println(f.firstUniqChar("loveleetcode"));
	}

}

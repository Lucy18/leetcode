package leetcode;

public class Repeated_Substring_Pattern_459 {

	public boolean repeatedSubstringPattern(String s) {
		int n=s.length();
		for(int sub_len=s.length()/2;sub_len>=1;sub_len--){
			if(n%sub_len==0){
				int times=n/sub_len;
				String subString=s.substring(0,sub_len);
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<times;i++){
					sb.append(subString);
				}
				if(sb.toString().equals(s)){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repeated_Substring_Pattern_459 r=new Repeated_Substring_Pattern_459();
		System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));
	}

}

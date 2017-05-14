package leetcode;

public class Longest_Uncommon_Subsequence_I_521 {

	public int findLUSlength(String a, String b) {
		if(a.equals(b)){
			return -1;
		}
		int aLength=a.length();
		int bLength=b.length();
		if(aLength>bLength){
			return aLength;
		}
		else if(aLength<bLength){
			return bLength;
		}
		else{
			return aLength;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Uncommon_Subsequence_I_521 l=new Longest_Uncommon_Subsequence_I_521();
		System.out.println(l.findLUSlength("aba", "cdcaaaba"));
	}

}

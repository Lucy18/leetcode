package leetcode;

public class Is_Subsequence_392 {

	public boolean isSubsequence(String s, String t) {
		char[] sc=s.toCharArray();
		char[] tc=t.toCharArray();
		int scPointer=0;
		int tcPointer=0;
		while(scPointer<sc.length&&tcPointer<tc.length){
			if(sc[scPointer]==tc[tcPointer]){
				scPointer++;
				tcPointer++;
			}
			else{
				tcPointer++;
			}
		}
		if(scPointer==sc.length){
			return true;
		}
		else{
			return false;
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Is_Subsequence_392 i=new Is_Subsequence_392();
		System.out.println(i.isSubsequence("axc", "ahbgdc"));
	}

}

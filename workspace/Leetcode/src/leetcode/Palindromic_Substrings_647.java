package leetcode;

public class Palindromic_Substrings_647 {

	public int countSubstrings(String s) {
		if(s.equals("")){
			return 0;
		}
		int count=0;
		char[] cs=s.toCharArray();
		int n=cs.length;
		boolean DP[][]=new boolean[n][n];
		for(int i=0;i<n;i++){
			DP[i][i]=true;
		}
		count+=n;
		for(int len=1;len<n;len++){
			for(int i=0;i<n-len;i++){
				int j=i+len;
				if(cs[i]!=cs[j]){
					DP[i][j]=false;
				}
				else{
					DP[i][j]=ifHuiWen(DP, i+1, j-1);
					if(DP[i][j]==true){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public boolean ifHuiWen(boolean DP[][],int i,int j){
		if(i>=j){
			return true;
		}
		else{
			return DP[i][j];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindromic_Substrings_647 p=new Palindromic_Substrings_647();
		System.out.println(p.countSubstrings("aaa"));
	}

}

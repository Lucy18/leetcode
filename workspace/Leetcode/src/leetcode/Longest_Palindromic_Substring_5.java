package leetcode;

public class Longest_Palindromic_Substring_5 {

	public String longestPalindrome(String s) {
		int begin=0;int end=0;
		char[] cs=s.toCharArray();
		int n=cs.length;
		boolean dp[][]=new boolean[n][n];
		for(int i=0;i<n;i++){
			dp[i][i]=true;
		}
		for(int i=0;i<n-1;i++){
			if(cs[i]==cs[i+1]){
				dp[i][i+1]=true;
				begin=i;end=i+1;
			}
		}
		for(int len=2;len<=n-1;len++){
			for(int i=0;i<n-len;i++){
				if(cs[i+len]==cs[i]&&dp[i+1][i+len-1]==true){
					dp[i][i+len]=true;
					begin=i;
					end=i+len;
				}
			}
		}
		return s.substring(begin, end+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Palindromic_Substring_5 l=new Longest_Palindromic_Substring_5();
		System.out.println(l.longestPalindrome("cbbd"));
	}

}

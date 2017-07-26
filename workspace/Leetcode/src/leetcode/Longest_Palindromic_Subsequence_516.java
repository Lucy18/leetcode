package leetcode;

public class Longest_Palindromic_Subsequence_516 {

	public int longestPalindromeSubseq(String s) {
		char[] cs=s.toCharArray();
		Integer[][] memo=new Integer[cs.length][cs.length];
		int longest=longest(cs, 0, cs.length-1, memo);
		return longest;
	}
	
	public int longest(char[] cs,int i,int j,Integer[][] memo){
		if(memo[i][j]!=null){
			return memo[i][j];
		}
		if(i>j){
			return 0;
		}
		if(i==j){
			return 1;
		}
		int longest=0;
		if(cs[i]==cs[j]){
			longest=2+longest(cs,i+1,j-1,memo);
		}
		else{
			longest=Math.max(longest(cs,i+1,j,memo), longest(cs,i,j-1,memo));
		}
		memo[i][j]=longest;
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Palindromic_Subsequence_516 l=new Longest_Palindromic_Subsequence_516();
		System.out.println(l.longestPalindromeSubseq("cbbd"));
	}

}

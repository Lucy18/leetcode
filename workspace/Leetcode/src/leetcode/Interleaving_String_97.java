package leetcode;

public class Interleaving_String_97 {

	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (m == 0) {
			return s2.equals(s3);
		}
		if (n == 0) {
			return s1.equals(s3);
		}
		if ((m + n) != s3.length()) {
			return false;
		}
		// dp[i][j] = true，
		// 表示s1的前i个字符(s1[0] ~ s[i - 1])和s2(s1[0] ~ s2[j -1])的前j的字符。
		// 可以构成s3的前i + j(s3[0] ~ s3[i + j -1])的字符。
		boolean dp[][] = new boolean[m + 1][n + 1];
		if (s1.charAt(0) == s3.charAt(0)) {
			dp[1][0] = true;
		}
		for (int i = 2; i <= m; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[i][0] = dp[i - 1][0];
			}
		}
		if (s2.charAt(0) == s3.charAt(0)) {
			dp[0][1] = true;
		}
		for (int i = 2; i <= n; i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[0][i] = dp[0][i - 1];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
				if (dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interleaving_String_97 i = new Interleaving_String_97();
		System.out.println(i.isInterleave("a", "b", "a"));
		System.out.println(i.isInterleave("aabc", "abad", "aabadabc"));
		System.out.println(i.isInterleave("ab", "bc", "babc"));
	}

}

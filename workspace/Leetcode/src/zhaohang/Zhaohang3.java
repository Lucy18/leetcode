package zhaohang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zhaohang3 {

	public int getResult(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] dp = new int[2 * n + 1];
		if (n >= 1) {
			dp[1] = 1;
		}
		for (int i = 2; i < 2 * n + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[j] + (i - j));
			}
			dp[2 * i] =dp[i] + 1;
			for (int j = 2 * i - 1; j > i; j--) {
				dp[j] = Math.min(dp[j], dp[2 * i] + (2 * i - j));
			}
		}
		return dp[n];
	}
	
	public long getResult2(int x){
		long[] dp = new long[x + 1];
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else {
                dp[i] = Math.min(dp[i], dp[i / 2 + 1] + 2);
            }
        }
        return dp[x];
	}

	public long getResult3(int x){
		 Map<Long, Long> dp = new HashMap<>();
	        dp.put(0L, 0L);
	        for (long i = 1; i <= x; i++) {
	            dp.put(i, dp.get(i - 1) + 1);
	            if (i % 2 == 0) {
	                dp.put(i, Math.min(dp.get(i), dp.get(i / 2) + 1));

	            } else {
	                dp.put(i, Math.min(dp.get(i), dp.get(i / 2 + 1) + 2));
	            }
	        }
	        return dp.get(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zhaohang3 h = new Zhaohang3();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(h.getResult(n));
		in.close();

	}

}

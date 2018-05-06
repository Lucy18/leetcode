package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class HuaWei3 {

	public void traceback(int n, int[][] m, int c, int[] x, int[] w) {
		for (int i = n; i > 1; i--) {
			if (m[i][c] == m[i - 1][c])
				x[i] = 0;
			else {
				x[i] = 1;
				c -= w[i];
			}
		}
		x[1] = (m[1][c] > 0) ? 1 : 0;
	}

	public ArrayList<Integer> getResult(int c, int n, int[] w, int[] v) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[][] m = new int[n + 1][c + 1];
		int[] x = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= c; j++) {
				if (j >= w[i])
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i]] + v[i]);
				else
					m[i][j] = m[i - 1][j];
			}
		}
		traceback(n, m, c, x, w);
		for (int i = 1; i <= n; i++) {
			if (x[i] == 1) {
				result.add(i);
			}
		}
		return result;
	}

	// f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：
	// f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuaWei3 h = new HuaWei3();
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int totalWeight = Integer.parseInt(s);
		s = in.nextLine();
		String[] sps = s.split(" ");
		int n = sps.length;
		int[] weight = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			weight[i] = Integer.parseInt(sps[i-1]);
		}
		s = in.nextLine();
		sps = s.split(" ");
		int[] value = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			value[i] = Integer.parseInt(sps[i-1]);
		}
		ArrayList<Integer> result = h.getResult(totalWeight, n, weight, value);
		System.out.print(result.get(0));
		for (int i = 1; i < result.size(); i++) {
			System.out.print(" " + result.get(i));
		}
		in.close();
	}

}

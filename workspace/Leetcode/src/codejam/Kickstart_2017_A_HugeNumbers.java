package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Kickstart_2017_A_HugeNumbers {

	int[][] input;
	long[] result;
	int count;

	public void readFromFile() {
		File file = new File("A-large-practice.in");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = reader.readLine();
			count = Integer.parseInt(tempString);
			input = new int[count][3];
			result = new long[count];
			int i = 0;
			while ((tempString = reader.readLine()) != null) {
				String[] tmp = tempString.split(" ");
				input[i][0] = Integer.parseInt(tmp[0]);
				input[i][1] = Integer.parseInt(tmp[1]);
				input[i][2] = Integer.parseInt(tmp[2]);
				i++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public void outputToFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("output.txt");
			for (int i = 1; i <= count; i++) {
				fw.write("Case #" + i + ": " + result[i - 1] + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public long solve(int A, int N, int P) {
		long yushu = A % P;
		for (int i = 2; i <= N; i++) {
			yushu = helper2(yushu, i, P);
		}
		System.out.println(yushu);
		return yushu;
	}

	// 计算(A^N)%P
	public int helper(int A, int N, int P) {
		if (A == 0 || A == 1) {
			return A % P;
		}
		if (N == 0) {
			return 1 % P;
		}
		long small = A % P;
		long ans = 1;
		for (int i = 0; i < N; i++) {
			ans = ans * small;
			ans = ans % P;
		}
		return (int)ans;
	}

	public long helper2(long A, int N, int P) {
		if (A == 0 || A == 1) {
			return A % P;
		}
		if (N == 0) {
			return 1 % P;
		}
		long half = helper2(A, N / 2, P);
		long ans = (half * half) % P;
		if (N % 2 == 0) {
			return ans;
		} else {
			return (ans * A) % P;
		}
	}

	public int solve2(int A, int N, int P) {
		int ans = 1;
		int n = factorial(N);
		for (int i = 1; i <= n; i++) {
			ans = (ans * A) % P;
		}
		;
		return ans;
	}

	public int factorial(int N) {
		if (N == 1) {
			return 1;
		}
		return N * factorial(N - 1);
	}

	public void procedure() {
		readFromFile();
		for (int i = 0; i < count; i++) {
			result[i] = solve(input[i][0], input[i][1], input[i][2]);
		}
		outputToFile();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kickstart_2017_A_HugeNumbers k = new Kickstart_2017_A_HugeNumbers();
		k.procedure();
//		System.out.println(k.helper(3, 3, 4));
//		System.out.println(k.helper2(3, 3, 4));
	}

}

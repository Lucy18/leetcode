package wangyi;

import java.util.Scanner;

public class WangYi2 {

	public int getCount(int n, int k) {
		int sum = n - k;
		for (int i = sum - 1; i > 0; i--) {
			sum += i;
		}
		for (int base = 2; base < n; base++) {
			int mult = 2;
			int num = base + k;
			if (num % base == 0) {
				continue;
			}
			while (num <= n) {
				if (num % base == k) {
					sum++;
				}
				num = base * mult + k;
				mult++;
			}
		}
		return sum;
	}

	public int getCount2(int n, int k) {
		int sum = 0;
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				if (x % y >= k) {
					sum++;
				}
			}
		}
		return sum;
	}

	public int getCount3(int n, int k) {
		int sum = n - k;
		for (int i = sum - 1; i > 0; i--) {
			sum += i;
		}
		for (int y = 2; y <= n; y++) {
			int muti = 1;
			int x=y * muti + k;
			while (x <= n) {				
				while (x < y * (muti + 1)) {
					if (x % y >= k) {
						sum++;
					}
					x++;
				}
				muti++;
				x = y * muti + k;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		WangYi2 t = new WangYi2();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println(t.getCount3(n, k));
		in.close();
	}
}

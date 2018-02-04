package suan_fa_ke;

public class BigIntegerMultiply {

	long calculate(long X, long Y) {
		if (X == 0 || Y == 0) {
			return 0;
		} else if (X < 10 && Y < 10)
			return X * Y;
		else {
			int xn = getLen(X);
			int yn = getLen(Y);
			int maxn = Math.max(xn, yn);
			int n = maxn / 2;

			long A = (long) (X / Math.pow(10, n));
			long B = (long) (X % Math.pow(10, n));
			long C = (long) (Y / Math.pow(10, n));
			long D = (long) (Y % Math.pow(10, n));

			long AC = calculate(A, C);
			long BD = calculate(B, D);
			long ABCD = calculate(A + B, C + D) - AC - BD;

			return (long) (AC * Math.pow(10, n + n) + ABCD * Math.pow(10, n) + BD);
		}
	}

	public int getLen(long x) {
		if (x < 10)
			return 1;
		return getLen(x / 10) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigIntegerMultiply b = new BigIntegerMultiply();
		System.out.println(b.calculate(123, 45678));
	}

}

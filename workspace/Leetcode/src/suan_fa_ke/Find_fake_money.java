package suan_fa_ke;

public class Find_fake_money {

	public int sum_coin(int a[], int from, int to) {
		int i, sum = 0;
		for (i = from; i <= to; i++) {
			sum += a[i];
		}
		return sum;
	}

	public int check_coin(int a[], int low, int high) {
		int step, mid1, mid2, n = high - low + 1;
		if (n == 1)
			return low;
		else {
			if (n % 3 == 0)
				step = n / 3;
			else
				step = n / 3 + 1;
			mid1 = low + step;// 第二部分开始的位置
			mid2 = mid1 + step;// 第三部分开始的位置
			int sum1 = sum_coin(a, low, mid1 - 1);
			int sum2 = sum_coin(a, mid1, mid2 - 1);
			if (sum1 == sum2)
				return check_coin(a, mid2, high);
			else {
				if (sum1 < sum2)
					return check_coin(a, low, mid1 - 1);
				else
					return check_coin(a, mid1, mid2 - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_fake_money f=new Find_fake_money();
		int[] a=new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2};
		System.out.println(f.check_coin(a, 0, a.length-1));
	}

}

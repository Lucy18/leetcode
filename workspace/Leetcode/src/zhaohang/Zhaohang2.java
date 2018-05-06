package zhaohang;

import java.util.ArrayList;
import java.util.Scanner;

public class Zhaohang2 {

	public int getResult(int n) {
		if (n <= 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < n){// 循环的条件		
			int m2 = list.get(i2) * 2;
			int m3 = list.get(i3) * 3;
			int m5 = list.get(i5) * 5;
			int min = Math.min(m2, Math.min(m3, m5));
			list.add(min);
			if (min == m2)
				i2++;
			if (min == m3)
				i3++;
			if (min == m5)
				i5++;
		}
		return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zhaohang2 h=new Zhaohang2();
		Scanner in = new Scanner(System.in);		
		int n=in.nextInt();
		System.out.println(h.getResult(n));
		in.close();
	}

}

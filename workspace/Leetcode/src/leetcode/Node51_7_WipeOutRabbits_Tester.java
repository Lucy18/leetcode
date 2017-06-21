package leetcode;

public class Node51_7_WipeOutRabbits_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = (int) Math.ceil(Math.random() * 10);
		int m = (int) Math.ceil(Math.random() * 10);
		System.out.println(n+" "+m);
		for(int i=0;i<n;i++){
			int xue=(int) Math.ceil(Math.random() * 100);
			System.out.println(xue);
		}
		for(int i=0;i<m;i++){
			int jian=(int) Math.ceil(Math.random() * 100);
			int qian=(int) Math.ceil(Math.random() * 100);
			System.out.println(jian+" "+qian);
		}
	}

}

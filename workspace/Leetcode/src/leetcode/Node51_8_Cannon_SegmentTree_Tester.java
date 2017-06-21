package leetcode;

public class Node51_8_Cannon_SegmentTree_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node51_8_Cannon_SegmentTree node=new Node51_8_Cannon_SegmentTree();
		for (int count = 0; count < 100; count++) {
			int m = (int) Math.ceil(Math.random() * 50000);
			int n = (int) Math.ceil(Math.random() * 50000);
			int[] A = new int[m + 1];
			int[] B = new int[n];
			System.out.print(m + " " + n + " ");
			for (int i = 1; i <= m; i++) {
				int di = (int) Math.ceil(Math.random() * 50000);
				A[i] = di;
				System.out.print(di + " ");
			}
			for (int i = 0; i < n; i++) {
				int pao = (int) Math.ceil(Math.random() * 50000);
				B[i] = pao;
				System.out.print(pao + " ");
			}
			System.out.println();
			node.solve(m, n, A, B);
		}
	}

}

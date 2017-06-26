package leetcode;

public class Range_Addition_II_598 {

	public int maxCount(int m, int n, int[][] ops) {
		int minM=m;
		int minN=n;
		for(int i=0;i<ops.length;i++){
			int thisM=ops[i][0];
			int thisN=ops[i][1];
			minM=minM<=thisM?minM:thisM;
			minN=minN<=thisN?minN:thisN;
		}
		return minM*minN;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Range_Addition_II_598 r=new Range_Addition_II_598();
		int m=3;
		int n=3;		
		int[][] ops=new int[][]{			
		};
		System.out.println(r.maxCount(m, n, ops));
	}

}

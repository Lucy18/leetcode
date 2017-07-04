package leetcode;

import java.util.HashMap;

public class Sum_II_4_454 {

	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count=0;
		int n=A.length;
		HashMap<Integer, Integer> mapAB=new HashMap<Integer, Integer>();
		for(int pointerA=0;pointerA<n;pointerA++){
			for(int pointerB=0;pointerB<n;pointerB++){
				int sum=A[pointerA]+B[pointerB];
				mapAB.put(sum, mapAB.getOrDefault(sum, 0)+1);
			}
		}
		for(int pointerC=0;pointerC<n;pointerC++){
			for(int pointerD=0;pointerD<n;pointerD++){
				int sum=C[pointerC]+D[pointerD];
				if(mapAB.get(-sum)!=null){
					count+=mapAB.get(-sum);
				}
			}
		}
		return count;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum_II_4_454 s=new Sum_II_4_454();
		int[] A=new int[]{1,2};
		int[] B=new int[]{-2,-1};
		int[] C=new int[]{-1,2};
		int[] D=new int[]{0,2};
		System.out.println(s.fourSumCount(A, B, C, D));
	}

}

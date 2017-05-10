package leetcode;

public class Reshape_the_Matrix_566 {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int[][] newNums=new int[r][c];
		int maxNum=r*c;
		int count=0;
		int pointerx=0;
		int pointery=0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (pointerx == r) {
					return nums;
				}
				newNums[pointerx][pointery] = nums[i][j];
				count++;
				if (pointery + 1 == c) {
					pointerx++;
					pointery=0;
				} else {
					pointery++;
				}
			}
		}
		if(count<maxNum){
			return nums;
		}
		return newNums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reshape_the_Matrix_566 r=new Reshape_the_Matrix_566();
		int[][] a=new int[][]{{1,2,3,4}};
		int[][] result=r.matrixReshape(a, 2, 2);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}

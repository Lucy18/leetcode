package leetcode;

public class Spiral_Matrix_II_59 {

	public int[][] generateMatrix(int n) {
		int[] direction_x=new int[]{0,1,0,-1};//方向是顺时针
		int[] direction_y=new int[]{1,0,-1,0};//即 向右，向下，向左，向上
		int[][] matrix=new int[n][n];
		int x=0,y=0;
		int pointer=0;
		for(int i=1;i<=n*n;i++){
			matrix[x][y]=i;
			
			int nextX=x+direction_x[pointer];
			int nextY=y+direction_y[pointer];
			if( nextX<0 || nextX>=n || nextY<0 || nextY>=n ||
				matrix[nextX][nextY]!=0	
				){
				pointer=(pointer+1)%4;
				nextX=x+direction_x[pointer];
				nextY=y+direction_y[pointer];
			}
			x=nextX;
			y=nextY;
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral_Matrix_II_59 s=new Spiral_Matrix_II_59();
		int n=7;
		int[][] matrix=s.generateMatrix(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

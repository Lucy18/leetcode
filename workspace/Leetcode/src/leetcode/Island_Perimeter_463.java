package leetcode;

public class Island_Perimeter_463 {
	
	public int islandPerimeter(int[][] grid) {
		int zhouchang=0;
		int xLength=grid.length;
		int yLength=grid[0].length;
		for(int i=0;i<xLength;i++){
			for (int j = 0; j < yLength; j++) {
				if (grid[i][j] == 1) {
					if (i == 0 || grid[i - 1][j] == 0) {// 上
						zhouchang++;
					}
					if (i == xLength - 1 || grid[i + 1][j] == 0) {// 下
						zhouchang++;
					}
					if (j == 0 || grid[i][j - 1] == 0) {// 左
						zhouchang++;
					}
					if (j == yLength - 1 || grid[i][j + 1] == 0) {
						zhouchang++;
					}
				}
			}
		}
		return zhouchang;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Island_Perimeter_463 i=new Island_Perimeter_463();
		int[][] a=new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(i.islandPerimeter(a));
	}

}

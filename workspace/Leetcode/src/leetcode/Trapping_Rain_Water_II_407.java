package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Trapping_Rain_Water_II_407 {

	public int trapRainWater(int[][] heightMap) {
		if(heightMap.length<=2||heightMap[0].length<=2){
			return 0;
		}
		int m=heightMap.length;
		int n=heightMap[0].length;
		int count=0;
		boolean[][] visited=new boolean[m][n];
		//queue中存储外围的墙
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
			public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
		});
		
		for(int i=0;i<m;i++){
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			visited[i][0]=true;
			queue.offer(new Cell(i, n-1, heightMap[i][n-1]));
			visited[i][n-1]=true;
		}
		for(int i=0;i<n;i++){
			queue.offer(new Cell(0, i, heightMap[0][i]));
			queue.offer(new Cell(m-1, i, heightMap[m-1][i]));
			visited[0][i]=true;
			visited[m-1][i]=true;
		}
		int[][] direction=new int[][]{
				{-1,0},{0,-1},{1,0},{0,1}
		};//上，左，下，右
		while(!queue.isEmpty()){
			Cell cell=queue.poll();
			for(int i=0;i<4;i++){
				int newX=cell.x+direction[i][0];
				int newY=cell.y+direction[i][1];
				if(newX<0||newX>=m||newY<0||newY>=n){
					continue;
				}
				if(!visited[newX][newY]){
					if(heightMap[newX][newY]>=heightMap[cell.x][cell.y]){
						//将它作为新的墙
						queue.offer(new Cell(newX, newY, heightMap[newX][newY]));
					}
					else{
						count+=(heightMap[cell.x][cell.y]-heightMap[newX][newY]);
						heightMap[newX][newY]=heightMap[cell.x][cell.y];
						//水坑填满水后高度设为填完水之后的高度，可以看做是墙
						queue.offer(new Cell(newX, newY, heightMap[newX][newY]));
					}
					visited[newX][newY]=true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trapping_Rain_Water_II_407 t=new Trapping_Rain_Water_II_407();
		int[][] heightMap=new int[][]{
			{1,3,3,1,3,2},
			{3,2,1,3,2,3},
			{3,3,3,2,3,1}
		};
		System.out.println(t.trapRainWater(heightMap));
	}
	
	class Cell {
        int x;
        int y;
        int height;
        public Cell(int row, int col, int height) {
            this.x = row;
            this.y = col;
            this.height = height;
        }
    }

}

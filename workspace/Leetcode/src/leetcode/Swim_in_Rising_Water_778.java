package leetcode;

import java.util.PriorityQueue;

public class Swim_in_Rising_Water_778 {

	public int swimInWater(int[][] grid) {
		int n=grid.length;
		int[][] direction=new int[][]{
			{-1,0},{1,0},{0,-1},{0,1}//上下左右
		};
		boolean[][] visited=new boolean[n][n];
		PriorityQueue<Coordinate> pq=new PriorityQueue<Coordinate>((a,b) -> a.val-b.val);
		pq.offer(new Coordinate(0, 0, grid[0][0]));
		int max=0;
		while(!pq.isEmpty()){
			Coordinate c=pq.poll();
			visited[c.x][c.y]=true;
			max=Math.max(max, c.val);
			if(c.x==n-1&&c.y==n-1){				
				break;
			}
			for(int i=0;i<4;i++){
				int newX=c.x+direction[i][0];
				int newY=c.y+direction[i][1];
				if(newX<0||newX>=n||newY<0||newY>=n||visited[newX][newY]==true){
					continue;
				}
				pq.offer(new Coordinate(newX, newY, grid[newX][newY]));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Swim_in_Rising_Water_778 s=new Swim_in_Rising_Water_778();
		int[][] grid=new int[][]{
			{0,1,2,3,4},
			{24,23,22,21,5},
			{12,13,14,15,16},
			{11,17,18,19,20},
			{10,9,8,7,6}
		};
		System.out.println(s.swimInWater(grid));
	}
	
	class Coordinate{
		int x;
		int y;
		int val;
		public Coordinate(int x,int y,int val){
			this.x=x;
			this.y=y;
			this.val=val;
		}
	}
}

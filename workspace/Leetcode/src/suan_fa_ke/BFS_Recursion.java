package suan_fa_ke;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Recursion {
	
	public void BFS(int[][] matrix,boolean[] visited,Queue<Integer> queue){
		if(queue.size()==0){
			return;
		}
		int val=queue.poll();
		System.out.println(val);
		visited[val]=true;
		for(int i=0;i<matrix.length;i++){
			if(matrix[val][i]!=0&&visited[i]==false&&!queue.contains(i)){
				queue.offer(i);
			}
		}
		BFS(matrix,visited,queue);
	}
	
	public void traversingGraph(int[][] matrix){
		boolean[] visited=new boolean[matrix.length];
		int first=-1;
		//找到一个不为0（跟其他点有关联）的结点
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				if(matrix[i][j]!=0){
					first=i;
					break;
				}
			}
			if(first!=-1){
				break;
			}
		}
		if(first!=-1){
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.offer(first);
			BFS(matrix,visited,queue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS_Recursion b=new BFS_Recursion();
		int[][] matrix=new int[][]{
			{0,1,1,0,0,0,0},
			{1,0,0,1,1,0,0},
			{1,0,0,0,0,1,1},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0}
		};
		b.traversingGraph(matrix);
	}

}

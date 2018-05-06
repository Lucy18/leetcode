package leetcode;

import java.util.Arrays;

public class Cheapest_Flights_Within_K_Stops_787 {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] matrix = new int[n][n];
		for (int i = 0; i < flights.length; i++) {
			matrix[flights[i][0]][flights[i][1]] = flights[i][2];
		}
		int[] step = new int[n];//记录距离src有step步
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int[] visited = new int[n];// 判断是否已确定visited[i]的最短距离
		distance[src] = 0;
		visited[src] = 1;
		for(int i=1;i<n;i++){ //一次去掉一个node，src已经去掉，还要去掉n-1个node
			int min = Integer.MAX_VALUE;
			int minNode = src;
			for(int j=0;j<n;j++){
				if(visited[j]==0&&distance[j]<min){
					minNode=j;
					min=distance[j];
				}
			}
			visited[minNode]=1;
			for (int j = 0; j < n; j++) {
				if (visited[j] == 1) {
					continue;
				}
				if (matrix[minNode][j] != 0  
						&& distance[minNode] + matrix[minNode][j] < distance[j]
								&&step[minNode]+1<=K+1) {
					//因为src到下一个点，也算了一步step，所以要K+1
					distance[j] = distance[minNode] + matrix[minNode][j];
					step[j]=step[minNode]+1;
				}
			}
			if(minNode==dst){
				break;
			}
		}
		if (distance[dst] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return distance[dst];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cheapest_Flights_Within_K_Stops_787 c = new Cheapest_Flights_Within_K_Stops_787();
//		int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
//		System.out.println(c.findCheapestPrice(3, flights, 0, 2, 1));
//		int[][] flights = new int[][] { { 4, 1, 1 }, { 1, 2, 3 }, { 0, 3, 2 }, { 0, 4, 10 }, { 3, 1, 1 }, { 1, 4, 3 } };
//		System.out.println(c.findCheapestPrice(5, flights, 2, 1, 1));
//		int[][] flights = new int[][]
//			{
//				{16,1,81},{15,13,47},{1,0,24},{5,10,21},{7,1,72},{0,4,88},
//				 {16,4,39},{9,3,25},{10,11,28},{13,8,93},{10,3,62},{14,0,38},
//				 {3,10,58},{3,12,46},{3,8,2},{10,16,27},{6,9,90},{14,8,6},
//				 {0,13,31},{6,4,65},{14,17,29},{13,17,64},{12,5,26},{12,1,9},
//				 {12,15,79},{16,11,79},{16,15,17},{4,0,21},{15,10,75},{3,17,23}
//						 ,{8,5,55},{9,4,19},{0,10,83},{3,7,17},{0,12,31},{11,5,34},
//						 {17,14,98},{11,14,85},{16,7,48},{12,6,86},{5,17,72},
//						 {4,12,5},{12,10,23},{3,2,31},{12,7,5},{6,13,30},{6,7,88},
//						 {2,17,88},{6,8,98},{0,7,69},{10,15,13},{16,14,24},{1,17,24},
//						 {13,9,82},{13,6,67},{15,11,72},{12,0,83},{1,4,37},{12,9,36},
//						 {9,17,81},{9,15,62},{8,15,71},{10,12,25},{7,6,23},{16,5,76},
//						 {7,17,4},{3,11,82},{2,11,71},{8,4,11},{14,10,51},{8,10,51},
//						 {4,1,57},{6,16,68},{3,9,100},{1,14,26},{10,7,14},{8,17,24},
//						 {1,11,10},{2,9,85},{9,6,49},{11,4,95}
//			};
//		System.out.println(c.findCheapestPrice(18, flights, 7, 2, 6));
		int[][] flights = new int[][] { {0, 1, 1}, {0,2,5},{1,2,1},{2,3,1} };
		System.out.println(c.findCheapestPrice(4, flights, 0, 3, 1));	
	}
}

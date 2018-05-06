package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Is_Graph_Bipartite_785 {

	public boolean isBipartite(int[][] graph) {
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			int belongTo = -1; // 判断 i 是belongTo哪个集合
			if (setA.contains(i)) {
				belongTo = 1;
			}
			for (int j = 0; j < graph[i].length; j++) {
				if (setA.contains(graph[i][j])) {
					belongTo = 2;
					break;
				}
			}
			if (belongTo == -1) {// 当前set里的数与当前点无关，所以belongTo放在哪里都没关系
				setA.add(i);
				for (int j = 0; j < graph[i].length; j++) {
					setB.add(graph[i][j]);
				}
			} else if (belongTo == 1) {
				for (int j = 0; j < graph[i].length; j++) {
					if (setA.contains(graph[i][j])) {
						return false;
					} else {
						setB.add(graph[i][j]);// 无论有没有，都加，反正不会重复
					}
				}
			} else {// belongTo==2
				setB.add(i);
				for (int j = 0; j < graph[i].length; j++) {
					if (setB.contains(graph[i][j])) {
						return false;
					} else {
						setA.add(graph[i][j]);// 无论有没有，都加，反正不会重复
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Is_Graph_Bipartite_785 is=new Is_Graph_Bipartite_785();
		int[][] graph=new int[][]{
			{1,2,3},{0,2},{0,1,3},{0,2}
		};
		System.out.println(is.isBipartite(graph));
	}

}

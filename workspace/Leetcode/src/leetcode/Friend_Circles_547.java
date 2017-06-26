package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Friend_Circles_547 {
	class UnionFind {  
        private int count = 0;  
        private int[] parent, rank;  
          
        public UnionFind(int n) {  
            count = n;  
            parent = new int[n];  
            rank = new int[n];  
            for (int i = 0; i < n; i++) {  
                parent[i] = i;  
            }  
        }  
          
        public int find(int p) {  
            int q = parent[p];  
            while (q != parent[q]) {  
                q = parent[q];  
            }  
            parent[p] = q;  
            return q;  
        }  
          
        public void union(int p, int q) {  
            int rootP = find(p);  
            int rootQ = find(q);  
            if (rootP == rootQ) return;  
            if (rank[rootQ] > rank[rootP]) {  
                parent[rootP] = rootQ;  
            }  
            else {  
                parent[rootQ] = rootP;  
                if (rank[rootP] == rank[rootQ]) {  
                    rank[rootP]++;  
                }  
            }  
            count--;  
        }  
          
        public int count() {  
            return count;  
        }  
          
        public int getMaxUnion() {  
            Map<Integer, Integer> map = new HashMap<>();  
            int max = 1;  
            for (int i = 0; i < parent.length; i++) {  
                int p = find(i);  
                map.put(p, map.getOrDefault(p, 0) + 1);  
                max = Math.max(max, map.get(p));  
            }  
            return max;  
        } 
        
    }  

	int findParent(int[] parent,int index){
		while(parent[index]!=index){
			index=parent[index];
		}
		return index;
	}

	public int findCircleNum(int[][] M) {
		int n=M.length;
		int heng=0;
		int shu=0;
        UnionFind uf = new UnionFind(n);  
		for(shu=0;shu<n;shu++){
			for(heng=shu;heng<n;heng++){//因为是对角线对称的，所以只要看右上角部分
				if(M[shu][heng]==1){
					uf.union(shu, heng);
				}				
			}
		}
		return uf.count; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend_Circles_547 f=new Friend_Circles_547();
		int[][] M=new int[][]{
			{1,1,0},
			{1,1,1},
			{0,1,1}
		};
		System.out.println(f.findCircleNum(M));
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if(matrix.length==0||matrix[0].length==0){
			return list;
		}
		int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }// 右下左上
		};
		int m=matrix.length;
		int n=matrix[0].length;
		int dPointer=0;
		int x=0;
		int y=-1;
		m--;
		while(m!=0&&n!=0){
			if(dPointer%2==0){//横着走,走的是列数
				for(int i=0;i<n;i++){
					x=x+direction[dPointer][0];
					y=y+direction[dPointer][1];
					list.add(matrix[x][y]);
				}
				n--;
			}
			else{//竖着走，走的是行数
				for(int i=0;i<m;i++){
					x=x+direction[dPointer][0];
					y=y+direction[dPointer][1];
					list.add(matrix[x][y]);
				}
				m--;				
			}
			dPointer=(dPointer+1)%4;
		}
		if(dPointer%2==0){//横着走,走的是列数
			for(int i=0;i<n;i++){
				x=x+direction[dPointer][0];
				y=y+direction[dPointer][1];
				list.add(matrix[x][y]);
			}
		}
		else{//竖着走，走的是行数
			for(int i=0;i<m;i++){
				x=x+direction[dPointer][0];
				y=y+direction[dPointer][1];
				list.add(matrix[x][y]);
			}				
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral_Matrix_54 s=new Spiral_Matrix_54();
		int[][] matrix=new int[][]{
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15}
		};
		List<Integer> list=s.spiralOrder(matrix);
		for(int i:list){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Diagonal_Traverse_498 {

	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix.length==0){
			return new int[]{};
		}
		List<Integer> list=new ArrayList<Integer>();
		int m=matrix.length;
		int n=matrix[0].length;
		int sum=0;
		int x=0,y=0;
		boolean isOdd=false;
		while(sum<=(m-1+n-1)){
			if (isOdd == true) {
				x = 0;
				if(sum-x>=n){
					y=n-1;
					x=sum-(n-1);
				}
				else{
					y=sum-x;
				}
			}
			else{
				y=0;
				if(sum-y>=m){
					x=m-1;
					y=sum-(m-1);
				}
				else{
					x=sum-y;
				}
			}
			while(x>=0&&y>=0){
				if(x<m&&y<n){
					list.add(matrix[x][y]);
				}
				if(isOdd==true){
					x++;	
				}
				else{
					x--;
				}
				y=sum-x;
			}
			if(isOdd==true){
				isOdd=false;
			}
			else{
				isOdd=true;
			}
			sum++;
		}
		int[] result=new int[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diagonal_Traverse_498 d=new Diagonal_Traverse_498();
		int[][] matrix=new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		System.out.println(Arrays.toString(d.findDiagonalOrder(matrix)));
	}

}

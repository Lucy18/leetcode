package leetcode;

public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

	public int kthSmallest(int[][] matrix, int k) {
		int n=matrix.length;
		int low=matrix[0][0];
		int high=matrix[n-1][n-1];
		while(low<=high){
			int mid=(int)(((long)low+(long)high)/2);
			int count=getLessEqual(matrix, mid);
			if(count<k){
				low=mid+1;
			}
			else{
				high=mid-1;
			}
		}
		return low;
	}
	
	//找到某个数在matrix中是第几大
	public int getLessEqual(int[][] matrix, int val){
		int count=0;
		int n=matrix.length;
		int i=n-1;int j=0;
		while(i>=0&&j<n){
			if(matrix[i][j]>val){
				i--;
			}
			else{
				count=count+(i+1);
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kth_Smallest_Element_in_a_Sorted_Matrix_378 k=new Kth_Smallest_Element_in_a_Sorted_Matrix_378();
		int[][] matrix=new int[][]{
			{2000000000}
		};
		System.out.println(k.kthSmallest(matrix, 1));	
	}

}

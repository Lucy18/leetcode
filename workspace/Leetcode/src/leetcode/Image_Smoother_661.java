package leetcode;

public class Image_Smoother_661 {

	public int[][] imageSmoother(int[][] M) {
		if(M.length==0||M[0].length==0){
			return M;
		}		
		int m=M.length;
		int n=M[0].length;
		int[][] result=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int average=getAverage(M, i, j, m, n);
				result[i][j]=average;
			}
		}
		return result;
	}
	
	//把 它四周的8个元素的和 全算出来
	public int getAverage(int[][] M,int i,int j,int m,int n){
		int sum=0;
		sum+=M[i][j];
		int count=1;
		if(i-1>=0&&j-1>=0){
			sum+=M[i-1][j-1];
			count++;
		}
		if(i-1>=0){
			sum+=M[i-1][j];
			count++;
		}
		if(i-1>=0&&j+1<n){
			sum+=M[i-1][j+1];
			count++;
		}
		if(j-1>=0){
			sum+=M[i][j-1];
			count++;
		}
		if(j+1<n){
			sum+=M[i][j+1];
			count++;
		}
		if(i+1<m&&j-1>=0){
			sum+=M[i+1][j-1];
			count++;
		}
		if(i+1<m){
			sum+=M[i+1][j];
			count++;
		}
		if(i+1<m&&j+1<n){
			sum+=M[i+1][j+1];
			count++;
		}
		int result=(int)Math.floor((double)sum/count);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image_Smoother_661 im=new Image_Smoother_661();
		int[][] M=new int[][]{
			{2,3,4},
			{5,6,7},
			{8,9,10},
			{11,12,13},
			{14,15,16}
		};
		int[][] result=im.imageSmoother(M);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
